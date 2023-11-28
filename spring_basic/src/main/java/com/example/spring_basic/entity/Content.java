package com.example.spring_basic.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Content {
    private String sender;
    private String receiver;
    private String message;
    private LocalDateTime timestamp;
}
