package com.example.spring_basic.service;

import com.example.spring_basic.component.FileCountTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void asyncMethod() {
        // 模拟耗时的异步操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行了异步任务，返回结果");
    }

    @Async
    public CompletableFuture<String> performAsyncTask() {
        try {
            Thread.sleep(2000);
            String str = "我是执行异步方法后的返回值GGB";
            return CompletableFuture.completedFuture(str);
        } catch (InterruptedException e) {
            log.error("异步方法执行出现异常" + e.getMessage());
            return CompletableFuture.completedFuture(e.getMessage());
        }
    }
}
