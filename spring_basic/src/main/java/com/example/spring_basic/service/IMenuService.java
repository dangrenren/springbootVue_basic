package com.example.spring_basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spring_basic.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {
    List<Menu> findMenus(String name);
}
