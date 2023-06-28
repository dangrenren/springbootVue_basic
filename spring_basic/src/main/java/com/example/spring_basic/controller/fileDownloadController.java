package com.example.spring_basic.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.spring_basic.common.Result;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件上传和下载。新增区块链相关文件与下载，与这个瑞吉外卖图片文件上传与下载区分开 。
 */
@Controller
@RequestMapping("/common")
@Slf4j
public class fileDownloadController {

    @Value("${reggie.path}")
    private String basePath;

    @Value(value = "${files.upload.path}")
    private String uploadFilePath;

    @Value(value = "${files.download.path}")
    private String downloadFilePath;


    /**
     * 文件下载
     *
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            //输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }

            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //区块链相关文件上传与下载
    //文件上传

    @PostMapping("/uploadFile")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws JSONException {
        JSONObject result = new JSONObject();
        if (file.isEmpty()) {
            result.put("error", "空文件!");
            return result.toString();
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传文件名称为:{}, 后缀名为:{}!", fileName, suffixName);

        File fileTempObj = new File(uploadFilePath + "/" + fileName);
        // 检测目录是否存在
        if (!fileTempObj.getParentFile().exists()) {
            fileTempObj.getParentFile().mkdirs();
        }
        // 使用文件名称检测文件是否已经存在
        if (fileTempObj.exists()) {
            result.put("error", "文件已经存在!");
            return result.toString();
        }

        try {
            // 写入文件:方式1
            // file.transferTo(fileTempObj);
            // 写入文件:方式2
            FileUtil.writeBytes(file.getBytes(), fileTempObj);
        } catch (Exception e) {
            log.error("发生错误: {}", e);
            result.put("error", e.getMessage());
            return result.toString();
        }
        //2022.10.14 测试 。获得加密文件的哈希值 ，用来返回给前端页面记录
        try {
            String hashCode = DigestUtils.md5DigestAsHex(file.getBytes());//进行MD5哈希处理。
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.put("success", hashCode());
        return result.toString();
    }

    //文件下载
    // 下载到了默认的位置
    @GetMapping("/downloadFile")
    public String fileDownload(HttpServletResponse response, @RequestParam("fileName") String fileName) throws JSONException, IOException {
        JSONObject result = new JSONObject();

        File file = new File(downloadFilePath + '/' + fileName);
        if (!file.exists()) {
            result.put("error", "下载文件不存在!");
            return result.toString();
        }

        response.reset();
        //response.setContentType("application/octet-stream");
        response.setContentType("image/jpeg");

        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        //response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //attachment：弹出对话框让用户下载,inline直接显示在页面上 Content-Disposition代表处理方式
        response.setHeader("Content-Disposition", " inline;filename=" + fileName);

        // 原生的方式
        // try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
        //     byte[] buff = new byte[1024];
        //     OutputStream os = response.getOutputStream();
        //     int i = 0;
        //     while ((i = bis.read(buff)) != -1) {
        //         os.write(buff, 0, i);
        //         os.flush();
        //     }
        // } catch (IOException e) {
        //     log.error("发生错误: {}", e);
        //     result.put("error", e.getMessage());
        //     return result.toString();
        // }
        // 简单方式: 方式1
        // byte[] bytes = FileCopyUtils.copyToByteArray(file);
        // 简单方式: 方式2
        byte[] readBytes = FileUtil.readBytes(file);
        OutputStream os = response.getOutputStream();
        os.write(readBytes);
        result.put("success", "OK!");
        return result.toString();
    }

    //用户访问此服务器，此服务器连接到另一个服务器，将数据打印到控制台 .
    @GetMapping("/downloadOtherServer")
    public void otherFileDownload() throws IOException {
        //okhttp使用原文链接：https://blog.csdn.net/hc1285653662/article/details/127001439
        /**client执行newCall方法会得到一个Call对象，表示一个新的网络请求
         Call对象的execute方法是同步方法，会阻塞当前线程，其返回Response对象
         通过Response对象的isSuccessful()方法可以判断请求是否成功
         * **/
        //1、创建一个 OkHttpClient
        OkHttpClient client = new OkHttpClient();
        //2、创建Request对象
        Request request = new Request.Builder()
                .url("http://192.168.1.9:8080/common/downloadFile?fileName=123.txt")
                .build();
        //通过Call 来执行同步或异步请求，调用execute方法同步执行，调用enqueue方法异步执行
        Response responseOtherServer = client.newCall(request).execute();
        //通过Response对象的isSuccessful()方法可以判断请求是否成功。
        if (!responseOtherServer.isSuccessful()) {
            throw new IOException("Unexpected code " + responseOtherServer);
        } else {
            String s123 = new String(responseOtherServer.body().bytes());
            System.out.println(s123);
        }
    }

    //用户访问此服务器，此服务器连接到另一个服务器，将数据发送给用户 .
    @GetMapping("/downloadOtherServerFile")
    public void otherFileDownload(HttpServletResponse response, @RequestParam String fileName) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.9:8080/common/downloadFile?fileName=" + fileName)
                .build();
        Response responseOtherServer = client.newCall(request).execute();
        //通过Response对象的isSuccessful()方法可以判断请求是否成功。
        if (!responseOtherServer.isSuccessful()) {
            throw new IOException("Unexpected code " + responseOtherServer);
        }
        byte[] bytes = responseOtherServer.body().bytes();

        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength( bytes.length);设置响应体Body长度（字节长度），这个好像不是必须要设置,浏览器会自动识别
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //把从其他服务其器上读的字节发送给用户
        OutputStream os = response.getOutputStream();
        os.write(bytes);
        System.out.println("用户成功获得远程服务器上的文件");
    }

}
