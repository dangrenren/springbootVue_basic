package com.example.spring_basic.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring_basic.common.Constants;
import com.example.spring_basic.common.Result;
import com.example.spring_basic.entity.Menu;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.entity.dto.UserDTO;
import com.example.spring_basic.exception.ServiceException;
import com.example.spring_basic.mapper.RoleMapper;
import com.example.spring_basic.mapper.RoleMenuMapper;
import com.example.spring_basic.mapper.UserMapper;
import com.example.spring_basic.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

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

            String role = one.getRole(); // ROLE_ADMIN
            // 设置用户的菜单列表
            List<Menu> roleMenus = getRoleMenus(role);
            userDTO.setMenus(roleMenus);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    private List<Menu> getRoleMenus(String role) {
        Integer roleId = roleMapper.selectByFlag(role);
        // 当前角色的所有菜单id集合
        List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);
        /**
         * 我的写法
         //我查出来所有menu_id后，形成一个树形的列表，仿照之前青戈 MenuServiceImpl的findMenus方法行形成树形表的写法
         //先根据id 得到所需的菜单列表，再形成树形表
         List<Menu> list = new ArrayList<>();
         for (Integer menuId : menuIds) {
         list.add(menuService.getById(menuId));
         }
         //for (Menu menu : list) {//为什么不能打印？
         //   System.out.println(menu.getName());
         //}
         System.out.println("66666666666666666666666666666666666666666");
         //list处理为树形表
         // 找出pid为null的一级菜单
         List<Menu> roleMenus = list.stream().filter(menu -> menu.getPid() == null).collect(Collectors.toList());
         // 找出一级菜单的子菜单
         for (Menu menu : roleMenus) {
         // 筛选所有数据中pid=父级id的数据就是二级菜单
         menu.setChildren(list.stream().filter(m -> menu.getId().equals(m.getPid())).collect(Collectors.toList()));
         }
         return roleMenus;
         **/


        //这是青戈的写法，我不用这个，有点晦涩难懂
         // 查出系统所有的菜单(树形)
         List<Menu> menus = menuService.findMenus("");
         // new一个最后筛选完成之后的list
         List<Menu> roleMenus = new ArrayList<>();
         // 筛选当前用户角色的菜单
         for (Menu menu : menus) {
         if (menuIds.contains(menu.getId())) {
         roleMenus.add(menu);
         }
         List<Menu> children = menu.getChildren();
         // removeIf()  移除 children 里面不在 menuIds集合中的 元素
         children.removeIf(child -> !menuIds.contains(child.getId()));
         }
         return roleMenus;

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
