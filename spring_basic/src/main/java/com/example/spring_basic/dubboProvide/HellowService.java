package com.example.spring_basic.dubboProvide;/*
 *@description
 *@author dangren
 *@create 2023/11/16 17:01
 */

import com.example.api.init.MyDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

@DubboService
public class HellowService implements MyDubboService {
    @Override
    public String sayHellow(String name) {
        return "hello " + name;
    }
}
