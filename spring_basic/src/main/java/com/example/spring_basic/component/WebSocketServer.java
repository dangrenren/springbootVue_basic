package com.example.spring_basic.component;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author websocket服务
 */
@Component
@ServerEndpoint(value = "/imserver/{username}")
public class WebSocketServer {
    private static IUserService iUserService;

    @Autowired
    public void setiUserService(IUserService iUserService) {//Setter 方法注入
        WebSocketServer.iUserService = iUserService;
    }

    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 记录当前在线连接数
     */
    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessionMap.put(username, session);
        log.info("有新用户加入，username={}, 当前在线人数为：{}", username, sessionMap.size());
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        result.set("users", array);
        for (Object key : sessionMap.keySet()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("username", key);
            // {"username", "zhang", "username": "admin"}
            array.add(jsonObject);
        }
//        {"users": [{"username": "zhang"},{ "username": "admin"}]}
        sendAllMessage(JSONUtil.toJsonStr(result));  // 后台发送消息给所有的客户端
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessionMap.remove(username);
        log.info("有一连接关闭，移除username={}的用户session, 当前在线人数为：{}", username, sessionMap.size());
    }

    /**
     * 收到客户端消息后调用的方法
     * 后台收到客户端发送过来的消息
     * onMessage 是一个消息的中转站
     * 接受 浏览器端 socket.send 发送过来的 json数据
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username") String username) {
        log.info("服务端收到用户username={}的消息:{}", username, message);
        JSONObject obj = JSONUtil.parseObj(message);
        String toUsername = obj.getStr("to"); // to表示发送给哪个用户，比如 admin
        String text = obj.getStr("text"); // 发送的消息文本  hello
        // {"to": "admin", "text": "聊天文本"}
        if (toUsername != null) {//是发送给单人消息
            Session toSession = sessionMap.get(toUsername); // 根据 to用户名来获取 session，再通过session发送消息文本
            if (toSession != null) {
                // 服务器端 再把消息组装一下，组装后的消息包含发送人和发送的文本内容
                // {"from": "zhang", "text": "hello"}
                JSONObject jsonObject = new JSONObject();
                jsonObject.set("from", username);  // from 是 zhang
                jsonObject.set("text", text);  // text 同上面的text
                this.sendMessage(jsonObject.toString(), toSession);
                log.info("发送给用户username={}，消息：{}", toUsername, jsonObject.toString());
            } else {
                log.info("发送失败，未找到用户username={}的session", toUsername);
            }
        } else {//发送的是群组消息
            //根据消息和用户组名来发送群组消息
            //查询数据库，根据数据库来查询响应的群组用户。再根据对应的用户名查到对应的session，再发送消息
            String groupName = obj.getStr("groupName");
            System.out.println("获得用户组名{}" + groupName);
            //根据群组名查询群组里面的所有用户
            if (groupName != null) {
                List<User> members = iUserService.getMembersByGroupName(groupName);
                ArrayList<Session> arrayList = new ArrayList<>();
                for (User member : members) {
                    Session tosession = sessionMap.get(member.getUsername());
                    if (tosession != null) {
                        arrayList.add(tosession);
                    }
                }
                // 服务器端 再把消息组装一下，组装后的消息包含发送人和发送的文本内容
                // {"from": "zhang", "text": "hello"}
                //发送消息给群组里面的所有用户
                for (Session toSession : arrayList) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.set("from", username);  // from 是 zhang
                    jsonObject.set("text", message);  // text 同上面的text
                    this.sendMessage(jsonObject.toString(), toSession);
                    log.info("发送给用户群组{}，消息：{}", groupName, jsonObject.toString());
                }
            }
        }

    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 服务端发送消息给客户端
     */
    private void sendMessage(String message, Session toSession) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败", e);
        }
    }

    /**
     * 服务端发送消息给所有客户端
     */
    private void sendAllMessage(String message) {
        try {
            for (Session session : sessionMap.values()) {
                log.info("服务端给客户端[{}]发送消息{}", session.getId(), message);
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败", e);
        }
    }

    //2023.7.30 开发群聊功能
    //在数据库增加一个用户群组名字字段，根据用户名查询该用户在哪一个群组，然后服务器收到消息后只会将消息发送到它所在的群组里面的所有用户群组
}
