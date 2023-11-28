package com.example.spring_basic.component;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.spring_basic.entity.bean.ImageMessage;
import com.example.spring_basic.entity.bean.JoinInfo;
import com.example.spring_basic.entity.bean.MessageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class WeChatServer {
    @Value("${qauntumadd.path}")
    private String filePath;

    // 客户端映射
    private static Map<String, SocketIOClient> clientMap = new HashMap<>();
    // 人员名字映射
    private static Map<String, String> nameMap = new HashMap<>();
    // 群名称与群成员映射
    private static Map<String, Map<String, String>> groupMap = new HashMap<>();

    public void start() {
        Configuration config = new Configuration();
        // 如果调用了setHostname方法，就只能通过主机名访问，不能通过IP访问
        //config.setHostname("localhost");
        config.setPort(8098); // 设置监听端口
        final SocketIOServer server = new SocketIOServer(config);
        // 添加连接连通的监听事件
        server.addConnectListener(client -> {
            String sessionId = client.getSessionId().toString();
            System.out.println("getRemoteAddress " + client.getRemoteAddress().toString());
            System.out.println(sessionId + "已连接");
            clientMap.put(sessionId, client);
        });
        // 添加连接断开的监听事件
        server.addDisconnectListener(client -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "已断开");
            for (Map.Entry<String, SocketIOClient> item : clientMap.entrySet()) {
                if (!sessionId.equals(item.getKey())) {
                    item.getValue().sendEvent("friend_offline", nameMap.get(sessionId));
                }
            }
            for (Map.Entry<String, SocketIOClient> item : clientMap.entrySet()) {
                if (sessionId.equals(item.getKey())) {
                    clientMap.remove(item.getKey());
                    break;
                }
            }
            for (Map.Entry<String, Map<String, String>> group : groupMap.entrySet()) {
                group.getValue().remove(sessionId);
            }
            nameMap.remove(sessionId);
        });
        // 添加我已上线的监听事件
        server.addEventListener("self_online", String.class, (client, name, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "已上线：" + name);
            for (Map.Entry<String, SocketIOClient> item : clientMap.entrySet()) {
                item.getValue().sendEvent("friend_online", name);
                client.sendEvent("friend_online", nameMap.get(item.getKey()));
            }
            nameMap.put(sessionId, name);
        });
        // 添加我已下线的监听事件
        server.addEventListener("self_offline", String.class, (client, name, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "已下线：" + name);
            for (Map.Entry<String, SocketIOClient> item : clientMap.entrySet()) {
                if (!sessionId.equals(item.getKey())) {
                    item.getValue().sendEvent("friend_offline", name);
                }
            }
            nameMap.remove(sessionId);
        });
        // 添加文本发送的事件监听器
        server.addEventListener("send_friend_message", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "发送消息：" + json.toString());
            MessageInfo message = (MessageInfo) JSONObject.toJavaObject(json, MessageInfo.class);
            for (Map.Entry<String, String> item : nameMap.entrySet()) {
                if (message.getTo().equals(item.getValue())) {
                    clientMap.get(item.getKey()).sendEvent("receive_friend_message", message);
                    break;
                }
            }
        });
        // 添加图像发送的事件监听器
        server.addEventListener("send_friend_image", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "发送图片：" + json.toString());
            ImageMessage message = (ImageMessage) JSONObject.toJavaObject(json, ImageMessage.class);
            System.out.println("getFrom=" + message.getFrom() + ",getTo=" + message.getTo() + ",getName=" + message.getPart().getName());
            for (Map.Entry<String, String> item : nameMap.entrySet()) {
                if (message.getTo().equals(item.getValue())) {
                    System.out.println(item.getKey() + "receive_friend_image");
                    clientMap.get(item.getKey()).sendEvent("receive_friend_image", message);
                    break;
                }
            }
        });
        // 添加入群的事件监听器
        server.addEventListener("join_group", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "已入群：" + json.toString());
            JoinInfo info = (JoinInfo) JSONObject.toJavaObject(json, JoinInfo.class);
            if (!groupMap.containsKey(info.getGroup_name())) {
                System.out.println("groupMap.put " + info.getGroup_name());
                groupMap.put(info.getGroup_name(), new HashMap<String, String>());
            }
            for (Map.Entry<String, Map<String, String>> group : groupMap.entrySet()) {
                System.out.println("群名称为" + group.getKey());
                if (info.getGroup_name().equals(group.getKey())) {
                    group.getValue().put(sessionId, info.getUser_name());
                    for (Map.Entry<String, String> user : group.getValue().entrySet()) {
                        System.out.println("群成员为" + user.getKey());
                        clientMap.get(user.getKey()).sendEvent("person_in_group", info.getUser_name());
                        System.out.println(user.getKey() + " person_in_group");
                    }
                    System.out.println("person_count=" + group.getValue().size());
                    client.sendEvent("person_count", group.getValue().size());
                }
            }
        });
        // 添加退群的事件监听器
        server.addEventListener("leave_group", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "已退群：" + json.toString());
            JoinInfo info = (JoinInfo) JSONObject.toJavaObject(json, JoinInfo.class);
            for (Map.Entry<String, Map<String, String>> group : groupMap.entrySet()) {
                if (info.getGroup_name().equals(group.getKey())) {
                    group.getValue().remove(sessionId);
                    for (Map.Entry<String, String> user : group.getValue().entrySet()) {
                        clientMap.get(user.getKey()).sendEvent("person_out_group", info.getUser_name());
                        System.out.println(user.getKey() + " person_out_group");
                    }
                }
            }
        });
        // 添加群消息发送的事件监听器
        server.addEventListener("send_group_message", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "发送消息：" + json.toString());
            MessageInfo message = (MessageInfo) JSONObject.toJavaObject(json, MessageInfo.class);
            for (Map.Entry<String, Map<String, String>> group : groupMap.entrySet()) {
                if (message.getTo().equals(group.getKey())) {
                    for (Map.Entry<String, String> user : group.getValue().entrySet()) {
                        if (!user.getValue().equals(message.getFrom())) {
                            clientMap.get(user.getKey()).sendEvent("receive_group_message", message);
                            System.out.println("receive_group_message 接收方为" + user.getKey());
                        }
                    }
                    break;
                }
            }
        });
        // 添加群图片发送的事件监听器
        server.addEventListener("send_group_image", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "发送图片：" + json.toString());
            ImageMessage message = (ImageMessage) JSONObject.toJavaObject(json, ImageMessage.class);
            for (Map.Entry<String, Map<String, String>> group : groupMap.entrySet()) {
                if (message.getTo().equals(group.getKey())) {
                    for (Map.Entry<String, String> user : group.getValue().entrySet()) {
                        if (!user.getValue().equals(message.getFrom())) {
                            clientMap.get(user.getKey()).sendEvent("receive_group_image", message);
                            System.out.println("receive_group_image 接收方为" + user.getKey());
                        }
                    }
                    break;
                }
            }
        });

        //添加密钥下载的监听器
        server.addEventListener("ask_MiYao_text", JSONObject.class, (client, json, ackSender) -> {
            String sessionId = client.getSessionId().toString();
            System.out.println(sessionId + "下载密钥文件：" + json.toString());

            //文件下载的json消息就跟普通的文本消息一致，只是我们可以使用比较的文件来测试下，大约5M
            MessageInfo message = (MessageInfo) JSONObject.toJavaObject(json, MessageInfo.class);
            System.out.println("getFrom=" + message.getFrom() + ",getTo=" + message.getTo() + ",getContent=" + message.getContent());
            //服务器取出本机密钥文件，发送给用户
            File file = new File("E:\\AndroidStudy\\myFirstApp\\testSecret.txt");
            try {
                file = new File(filePath);
                if (!file.createNewFile()) {
                    System.out.println("创建文件失败");
                }
            } catch (NullPointerException e) {
                //如果有异常，就新建一个文件
                if (e != null) {
                    System.out.println(e.getMessage());
                    file = new File("E:\\AndroidStudy\\myFirstApp\\testSecret.txt");
                }
            }


            //静态方法无法调用非静态变量。
            // 另外@value也不可以将属性给注入进来，因为需要用@conmpont让spring管理才可以拿到值。更重要的是@Value拿到的属性需要为非静态的。
            //所以现在陷入了一个尴尬的境地，既然静态方法无法调用非静态变量，那么我就不能用静态方法来实现这个功能了。
            //查阅得知 非静态方法可以调用静态的成员变量，但是静态方法不能调用非静态方法的成员变量。
            //所以直接将这个方法改为非静态方法就可以了。
            //(但是我测试了之后，发现得到到的属性仍然是null)
            String miYao = "";
            int curentChar = 0;
            try {
                if (file.exists()) {//如果文件存在，就从文件中读出数据(很长的字符串，大约5M)
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while ((curentChar = br.read()) != -1) {
                        miYao += (char) curentChar;
                    }
                    br.close();//关闭输入流
                } else {
                    //文件不存在抛出异常
                    throw new RuntimeException("File does not exist: " + file.getPath());
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            //打印出密钥
            System.out.println(miYao);
            //构建新消息，让用户接收
            MessageInfo newMessage = new MessageInfo(message.getFrom(), message.getTo(), miYao, false);

            //clientMap.get(item.getKey()).sendEvent("receive_friend_image", message);//服务器控制接收方接收
            //这里设置为该客户端自己为接收密钥文件方，接收密钥文件,然后在APP端更新自己的密钥文件
            client.sendEvent("receive_MiYao_text", newMessage);
            System.out.println(newMessage.content);

            //给对方也更新密钥文件,让对方也在app端保存密钥。
            for (Map.Entry<String, String> item : nameMap.entrySet()) {
                if (message.getTo().equals(item.getValue())) {
                    clientMap.get(item.getKey()).sendEvent("receive_MiYao_text", newMessage);
                    break;
                }
            }
        });

        server.start(); // 启动Socket服务
    }

}
