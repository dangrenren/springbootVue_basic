package com.example.spring_basic.entity.bean;

public class MessageInfo {
    public String from; // 消息的发送者
    public String to; // 消息的接收者
    public String content; // 消息内容

    public boolean isSecret;//是否量子加密

    public MessageInfo(String from, String to, String content, boolean isSecret) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.isSecret = isSecret;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return this.from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean isSecret) {
        this.isSecret = isSecret;
    }
}
