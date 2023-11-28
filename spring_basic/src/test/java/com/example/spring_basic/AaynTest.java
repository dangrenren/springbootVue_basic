package com.example.spring_basic;

import com.example.spring_basic.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

//加上webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
//是为了启动测试是不报错。不然注册ServerEndpointExporter时，会报非法，会因为websocket的使用需要web容器的启动
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
@Slf4j
public class AaynTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsync() {
        System.out.println("调用异步方法之前");
        asyncService.asyncMethod();
        System.out.println("调用异步方法之后");
    }

    @Test
    public void testAsync2() {
        System.out.println("调用异步方法之前");
        CompletableFuture<String> completableFuture = asyncService.performAsyncTask();
        completableFuture.thenAccept(str -> {
            System.out.println("接受到了异步方法返回的结果: " + str);
        });
        System.out.println("调用异步方法之后");
    }

    @Test
    public void testThread() {
        //新建thread 开始一个线程
        new Thread(() -> {
            System.out.println("线程执行了");
        }).start();

        //开始一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行了");
            }
        }).start();

    }

}
