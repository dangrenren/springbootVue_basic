package com.example.spring_basic.entity.dto;

import lombok.Data;
import lombok.ToString;

//接受前端请求参数
@Data
@ToString
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String token;
}
