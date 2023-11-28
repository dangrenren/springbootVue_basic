package com.example.spring_basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class test {
    @Value("${qauntumadd.path}")
    private String path;

    public void getPath() {
        System.out.println(path);
        System.out.println("66666666666666666666666666666666");
    }
}
