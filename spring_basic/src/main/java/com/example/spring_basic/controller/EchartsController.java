package com.example.spring_basic.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import com.example.spring_basic.common.Result;
import com.example.spring_basic.config.AuthAccess;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/echarts")

public class EchartsController {
    @Autowired
    private IUserService userService;

    @AuthAccess
    @GetMapping("/example")
    public Result getChartData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        //使用hutool功能生成ArrayList
        hashMap.put("x", CollUtil.newArrayList("Mon", "Tue", "Wed", "Thu", "Fri", "Sa", "Sun"));
        hashMap.put("y", CollUtil.newArrayList(150, 230, 224, 218, 135, 147, 560));
        return Result.success(hashMap);
    }

    @AuthAccess
    @GetMapping("/members")
    public Result members() {
        List<User> list = userService.list();
        int q1 = 0; // 第一季度
        int q2 = 0; // 第二季度
        int q3 = 0; // 第三季度
        int q4 = 0; // 第四季度
        for (User user : list) {

            Date createTime = user.getCreateTime();
            Quarter quarter = DateUtil.quarterEnum(createTime);
            switch (quarter) {//Q1-Q4代表1234，计算每个季度注册有多少人
                case Q1:
                    q1 += 1;
                    break;
                case Q2:
                    q2 += 1;
                    break;
                case Q3:
                    q3 += 1;
                    break;
                case Q4:
                    q4 += 1;
                    break;
                default:
                    break;
            }
        }
        return Result.success(CollUtil.newArrayList(q1, q2, q3, q4));
    }


}
