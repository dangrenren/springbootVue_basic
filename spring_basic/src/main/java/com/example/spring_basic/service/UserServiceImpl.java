package com.example.spring_basic.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring_basic.common.Constants;
import com.example.spring_basic.common.Result;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.entity.dto.UserDTO;
import com.example.spring_basic.exception.ServiceException;
import com.example.spring_basic.mapper.UserMapper;
import com.example.spring_basic.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> finaAllUsers() {
        return userMapper.findAll();
    }

    public boolean saveOneUser(User user) {
        return (userMapper.insertUser(user) > 0);
    }

    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    public Integer updateUser(User user) {
        return userMapper.update(user);
    }

    public List<User> getOnePageUser(Integer pageNum, Integer pageSize) {
        return userMapper.getPageUsers(pageNum, pageSize);
    }

    public Integer selectTotalUsers() {
        return userMapper.selectTotal();
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());

        User one = getOne(queryWrapper, true);
        if (one != null) {//查到的数据不为空，那么就是查到了用户，返回的是true.否则是返回false
            BeanUtil.copyProperties(one, userDTO, true); //hutoo工具，将User类属性复制到UserDTO中
            //设置Token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public Boolean registerUser(UserDTO userDTO) {
        //根据传来的数据进行查询，如果有同名的账户返回错误
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        User one = getOne(queryWrapper, true);
        if (one != null) {//非空代表查到了
            return false;
        }
        return true;
    }
}
