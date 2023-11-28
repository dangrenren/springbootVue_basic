package com.example.test.dubboUse;/*
 *@description
 *@author dangren
 *@create 2023/11/17 16:32
 */


import com.example.api.init.MyDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getHellow")
public class hellowController {
    @DubboReference
    private MyDubboService myDubboService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        String result = myDubboService.sayHellow(name);
        return "Greeting from Dubbo: " + result;
    }

    @GetMapping("/hellow")
    public String sayHellow(@RequestParam String name) {
        return "测试: " + name;
    }
}
