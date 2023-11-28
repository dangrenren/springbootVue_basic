package com.example.spring_basic.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring_basic.common.Constants;
import com.example.spring_basic.common.Result;
import com.example.spring_basic.config.AuthAccess;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.entity.dto.UserDTO;
import com.example.spring_basic.service.IUserService;
import com.example.spring_basic.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")

public class userController {

    @Autowired
    public IUserService iUserService;

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return iUserService.finaAllUsers();//返回json格式的所有user.
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        boolean addUser = iUserService.saveOneUser(user);
        if (addUser) {
            return Result.success(user);
        } else {
            return Result.error();
        }
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable Integer id) {
        return iUserService.deleteUser(id);
    }

    @DeleteMapping("/deleteBatch")
    public Boolean deleteBatch(@RequestBody List<Integer> ids) {
        return iUserService.removeByIds(ids);//删除返回的是true或者false
    }

    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        Integer affect1 = iUserService.updateUser(user);
        if (affect1 > 0) {
            return Result.success(user);
        } else {
            return Result.error();
        }
    }

    @GetMapping("/pageUser")
    public Map<String, Object> getPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = iUserService.getOnePageUser(pageNum, pageSize);
        Integer total = iUserService.selectTotalUsers();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;//返回总人数和当前页的人数
    }

    @GetMapping("/getPageUser")//根据名字模糊分页查询
    public Page<User> getPages(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String username,
                               @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String address) {
        Page<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);//根据名字分页查询
        queryWrapper.like("email", email);//根据邮箱分页查询
        queryWrapper.like("address", address);//根据地址分页查询
        queryWrapper.orderByDesc("id");//查询出的结果倒叙排列
        iUserService.page(page, queryWrapper);
        User currentUser = TokenUtils.getCurrentUser();
        System.out.println("===========xxxxxxxxxx" + currentUser.getUsername());//测试下后台可以获得当前Token的用户不
        return page;
    }

    /*
    用阿里的Easyexcel也可以做，不用hutool Poi
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<User> list = iUserService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器(hutool提供)
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名(如果在User类里使用@Alisa给属性起别名，那么就不用再在这里起别名了)
        writer.addHeaderAlias("username", "用户名");
        writer.addHeaderAlias("password", "密码");
        writer.addHeaderAlias("nickname", "昵称");
        writer.addHeaderAlias("email", "邮箱");
        writer.addHeaderAlias("phone", "电话");
        writer.addHeaderAlias("address", "地址");
        writer.addHeaderAlias("createTime", "创建时间");
        //writer.addHeaderAlias("avatarUrl", "头像");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    @PostMapping("/import")
    public Boolean imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
        //方式二：表头是英文的情况，这里暂且不写。程序员青戈的代码里有
        List<User> list = reader.readAll(User.class);
        return iUserService.saveBatch(list);//返回的结果是boolean型
    }

    /**
     * @PostMapping("/login") public  boolean userLogin(@RequestBody UserDTO userDTO){
     * String username = userDTO.getUsername();
     * String password = userDTO.getPassword();
     * if(StrUtil.isBlank(username)||StrUtil.isBlank(password)){//hutool提供的StrUtil
     * return  false;
     * }
     * return iUserService.login(userDTO);//crtl+Alt+B快捷键直接进入实现方法
     * }
     **/

    @PostMapping("/login")
    public Result userLogin(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {//hutool提供的StrUtil,判断前端是否为空
            return Result.error(Constants.CODE_400, "参数错误");
        }
        //crtl+Alt+B快捷键直接进入实现方法
        UserDTO loginUser = iUserService.login(userDTO);
        System.out.println(userDTO + "哈哈哈哈哈哈哈哈哈哈哈");

        return Result.success(loginUser);//返回的是{Constants.CODE_200, "", userDTO}
    }

    @PostMapping("/register")
    public Result userRegister(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {//hutool提供的StrUtil,判断前端是否为空
            return Result.error(Constants.CODE_400, "参数错误");
        } else if (iUserService.registerUser(userDTO)) {//返回的结果为true，代表新用户未重复
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            iUserService.save(user);//返回的值是boolean
            return Result.success();
        } else {
            return Result.error(Constants.CODE_400, "用户名重复");
        }
    }

    @GetMapping("/username/{username}")
    public Result findByUsername(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return Result.success(iUserService.getOne(queryWrapper));
    }

    @PostMapping("password")
    public Result alterPassword(@RequestBody String form) {
        //前端发来 password,newPassword,confirmPassword
        JSONObject jsonObject = JSON.parseObject(form);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String newPassword = jsonObject.getString("newPassword");
        //String confirmPassword = jsonObject.getString("confirmPassword");
        //对前端密码进行校验，如果通过，将其改为新密码，否则返回error
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User one = iUserService.getOne(new QueryWrapper<>(user));
        if (one != null) {
            //查到了对应用户,修改密码
            user.setPassword(newPassword);
            //将新用户密码写入到数据库中
            Integer result = iUserService.updateUser(user);
            if (result >= 1) {
                System.out.println("修改了密码");
            }
            return Result.success("修改密码成功");
        } else {
            System.out.println("修改密码出错，没有找到对应用户！");
            return Result.error("400", "密码错误");
        }
    }

    //@AuthAccess
    @GetMapping("/getUserGroupName/{username}")
    public Result getUserGroupName(@PathVariable String username) {
        String groupName = iUserService.getUserGroupName(username);
        /*
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = iUserService.getOne(queryWrapper);
        String groupName= user.getGroupName();
        */
        return Result.success(groupName);
    }


}
