package com.example.spring_basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.entity.dto.UserDTO;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> finaAllUsers();

    boolean saveOneUser(User user);

    Integer deleteUser(Integer id);

    Integer updateUser(User user);

    List<User> getOnePageUser(Integer pageNum, Integer pageSize);

    Integer selectTotalUsers();

    UserDTO login(UserDTO userDTO);

    Boolean registerUser(UserDTO userDTO);
}
