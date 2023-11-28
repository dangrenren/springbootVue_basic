package com.example.test.dubboUse;/*
 *@description
 *@author dangren
 *@create 2023/11/16 20:55
 */

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class tsetConsumer implements TestConsumerService {
    @Override
    public String sayHellow(String name) {
        return "hello " + name;
    }
}
