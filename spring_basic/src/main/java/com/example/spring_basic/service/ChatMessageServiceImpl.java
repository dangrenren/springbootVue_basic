package com.example.spring_basic.service;

import com.example.spring_basic.entity.ChatMessage;
import com.example.spring_basic.entity.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private final static Logger logger = LoggerFactory.getLogger(ChatMessageServiceImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int create() {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender("dangrenren");
        chatMessage.setReceiver("周领英");
        List<Content> contentList = new ArrayList<>();

        Content content1 = new Content();
        content1.setSender("dangrenren");
        content1.setMessage("123");
        content1.setReceiver("周领英");
        content1.setTimestamp(LocalDateTime.now());
        contentList.add(content1);
        Content content2 = new Content();
        content2.setSender("yaojing");
        content2.setMessage("321");
        content2.setReceiver("烧鸡");
        content2.setTimestamp(LocalDateTime.now());
        contentList.add(content2);

        chatMessage.setContentList(contentList);
        LocalDateTime time = LocalDateTime.now();
        chatMessage.setTimestamp(time);

        ChatMessage chat_messages = mongoTemplate.save(chatMessage, "chat_messages");
        if (chat_messages != null) {
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int deleteByCondition(ChatMessage condition) {
        return 0;
    }

    @Override
    public void update(ChatMessage chatMessage) {

    }

    @Override
    public ChatMessage getById(String id) {
        return null;
    }

    @Override
    public ChatMessage getByCondition(ChatMessage condition) {
        Query query = new Query();
        String sender = condition.getSender();
        if (sender != null) {
            query.addCriteria(Criteria.where("sender").is(sender));
            List<ChatMessage> ChatMessages = mongoTemplate.find(query, ChatMessage.class);
            if (ChatMessages != null) {
                ChatMessage chatMessage = ChatMessages.get(0);
                Content content = new Content();
                content.setSender("dangrenren");
                content.setReceiver("周领英");
                content.setMessage("打电话");
                content.setTimestamp(LocalDateTime.now());
                chatMessage.getContentList().add(content);
                return chatMessage;
            }
        } else {
            logger.error("mongoDB查询 sender is null");
        }
        return null;
    }

    @Override
    public List<ChatMessage> getByDetailCondition(ChatMessage condition) {

        Criteria criteria = new Criteria()
                .andOperator(
                        Criteria.where("sender").is(condition.getSender()),
                        Criteria.where("receiver").is(condition.getReceiver())
                        // Criteria.where("timestamp").gte(startDateTime),
                        //Criteria.where("timestamp").lte(endDateTime)
                );

        // 创建查询对象
        Query query = new Query(criteria);
        // 添加时间排序条件（按时间戳升序排序）
        query.with(Sort.by(Sort.Direction.ASC, "timestamp"));
        // 执行查询并返回结果
        return mongoTemplate.find(query, ChatMessage.class, "chat_messages");
    }

}
