package com.example.spring_basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spring_basic.entity.Role;


import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 青哥哥
 * @since 2022-02-10
 */
public interface IRoleService extends IService<Role> {
    void setRoleMenu(Integer roleId, List<Integer> menuIds);
    List<Integer> getRoleMenu(Integer roleId);
}
