package com.example.spring_basic.entity;
import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ren")
@ToString
//MyBatis-Plus在确定操作的表时，由BaseMapper的泛型决定，即实体类型决定，且默认操作的表名和实体类型的类名一致。(mybatis不需要对应)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //指定主键使用数据库ID自增策略

    @TableId(type = IdType.AUTO)//不配置这个的话，mybatis-plus会指定主键生成策略使用雪花算法（默认策略）
    private Integer id;


    @Alias("用户名")//(hutool工具起别名)
    private String username;

    /**
     * @JsonIgnore是一个能够在后端发送给前端数据的时候对后端发送出的json字符串能够发挥作用的一个注解 如果比如user表，你在password这个属性上添加@JsonIgnore，就会set和get方法都不会出现password，就是这个属性不会被作用，
     * 但是在注解get上，就会发现前端不会显示password的数据，注解在set上，后端就拿不到前端传过来的password的数据，
     **/
    private String password;
    private String nickname;
    private String phone;
    private String email;
    private String address;
    private Date createTime;

    @ApiModelProperty("角色")
    private String role;
    @TableField(value = "group_name")
    private String groupName;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * 但是问题来了，当在新增用户的时候password字段也被忽略了，导致密码字段为空值，
     * 出现在这个原因也是因为我们再password上加上@JsonIgnore 字段导致的
     * 我们只需要在对应的get，set方法上分别加上这两个注解即可：@JsonIgnore 返回时忽略，@JsonProperty 请求时注入
     * 就能满足我们的需求了
     */
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
