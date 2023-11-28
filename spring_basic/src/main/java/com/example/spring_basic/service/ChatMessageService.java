package com.example.spring_basic.service;

import com.example.spring_basic.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    int create();

    int delete(String id);

    int deleteByCondition(ChatMessage condition);

    void update(ChatMessage chatMessage);

    ChatMessage getById(String id);

    ChatMessage getByCondition(ChatMessage condition);

    //按照发送者和接收者查找，以及时间排序
    List<ChatMessage> getByDetailCondition(ChatMessage condition);
}
