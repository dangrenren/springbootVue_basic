package com.example.test.dubboUse;/*
 *@description
 *@author dangren
 *@create 2023/11/16 20:54
 */

import org.apache.dubbo.config.annotation.DubboService;


public interface TestConsumerService {
    public String sayHellow(String name);
}
