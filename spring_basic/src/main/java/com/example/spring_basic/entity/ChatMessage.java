package com.example.spring_basic.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "chat_messages")
@Data
public class ChatMessage {
    private String id;
    private String sender;
    private String receiver;
    private List contentList;
    private LocalDateTime timestamp;
    // 构造函数，getters和setters

}
