package com.example.spring_basic.component;

import com.example.spring_basic.controller.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartWeChatServer {
    @Autowired
    private WeChatServer weChatServer;
    @Autowired
    private com.example.spring_basic.controller.test test;

    @PostConstruct
    public void startWeChatServer() {//PostConstruct注解的方法将会在依赖注入完成后被自动调用
        weChatServer.start();
        test.getPath();
    }
}
