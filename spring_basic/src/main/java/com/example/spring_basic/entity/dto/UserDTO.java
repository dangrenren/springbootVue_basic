package com.example.spring_basic.entity.dto;

import com.example.spring_basic.entity.Menu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

//接受前端请求参数
@Data
@ToString
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String token;
    private String role;
    private List<Menu> menus;
}
