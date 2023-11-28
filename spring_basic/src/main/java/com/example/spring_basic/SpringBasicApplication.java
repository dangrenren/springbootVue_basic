package com.example.spring_basic;

import com.example.spring_basic.component.WeChatServer;
import com.example.spring_basic.controller.test;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
@EnableAdminServer
@EnableScheduling
@EnableAsync
@EnableDubbo
@EnableJpaRepositories("com.example.spring_basic.entity")
@EntityScan("com.example.spring_basic.entity")
public class SpringBasicApplication {
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(SpringBasicApplication.class, args);
        log.info("项目启动成功...");
    }
}
