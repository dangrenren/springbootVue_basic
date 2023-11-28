package com.example.spring_basic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

//我们需要在SpringBoot中配置一个线程池，这样才能让定时任务多线程并行执行
@Configuration
public class SheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //创建线程池
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));
    }
}
