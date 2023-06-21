package com.example.spring_basic.entity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test1")
//@ComponentScan(value =" com.example.spring_basic.controller")
//json就是指某种格式的字符串. JSON 英文全称 JavaScript Object NotatioJSON 是一种轻量级的数据交换格式。
public class test_1 {
    @GetMapping("/hellow")
    public String testHellow() {
        return "hellow world";
    }

}
