package com.example.spring_basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@TableName("role_menu")
@Data
public class RoleMenu {
    @Field("role_id")
    private Integer roleId;
    @Field("menu_id")
    private Integer menuId;

}
