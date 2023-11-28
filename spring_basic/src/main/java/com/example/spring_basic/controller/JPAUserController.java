package com.example.spring_basic.controller;

import com.example.spring_basic.entity.JPAUser;
import com.example.spring_basic.service.JPAUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class JPAUserController {
    /**
     * private final JPAUserService userService;
     *
     * @Autowired public JPAUserController(JPAUserService userService) {
     * this.userService = userService;
     * }
     **/
    @Autowired
    private JPAUserService userService;

    @GetMapping("/getAllUsers")
    public List<JPAUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public JPAUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    public JPAUser createUser(@RequestBody JPAUser user) {
        return userService.saveUser(user);
    }

    @PutMapping("/updateUser")
    public JPAUser updateUser(@RequestBody JPAUser user) {
        String email = user.getEmail();
        //跟数据库里相同的user.name进行比较，如果相同则删除
        List<JPAUser> users = userService.getAllUsers();
        JPAUser newUser = new JPAUser();
        for (JPAUser u : users) {
            //找到email相同的用户，修改这个用户的名字
            if (u.getEmail().equals(email)) {
                u.setName("修改后的名字：小吉吉" + user.getName());
                JPAUser jpaUser = userService.saveUser(u);
                newUser = jpaUser;
                break;//找到一个即可退出
            }
        }
        return newUser;
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody JPAUser user) {
        String name = user.getName();
        //跟数据库里相同的user.name进行比较，如果相同则删除
        List<JPAUser> users = userService.getAllUsers();
        for (JPAUser u : users) {
            if (u.getName().equals(name)) {
                userService.deleteUser(u.getId());
            }
        }
    }

    @GetMapping("/findPage")
    public List<JPAUser> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<JPAUser> page = userService.findPage(pageNum, pageSize);
        List<JPAUser> users = page.getContent();
        long totalRecords = page.getTotalElements();
        int totalPages = page.getTotalPages();
        return users;
    }
}
