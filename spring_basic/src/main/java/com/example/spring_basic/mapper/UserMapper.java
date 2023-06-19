package com.example.spring_basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_basic.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from ren")
    public List<User> findAll();

    @Insert("insert into ren (username,password,nickname,email,phone,address,create_time) values (#{username},#{password},#{nickname},#{email},#{phone},#{address},#{createTime})")
    int insertUser(User user);

    int update(User user);

    @Delete("delete from ren where id=#{id}")
    Integer deleteById(@Param("id") Integer id);//Param对于多个参数时使用，这里也可以加。 @Param("id")括号里的属性要与#{}属性一致

    //模糊查询，为了之后的搜索框可以搜索。这里先注释掉，以后再完善搜索框的内容。
    //@Select("select * from ren where username like contact('%',#{username},'%')) limit #{pageNum},#{pageSize}")

    /**
     * Mysql concat()函数
     * 1、功能：将多个字符串连接成一个字符串。
     * 2、语法：concat(str1, str2,...)
     * 返回结果为连接参数产生的字符串，如果有任何一个参数为null，则返回值为null
     **/
    @Select("select * from ren limit #{pageNum},#{pageSize}")
    List<User> getPageUsers(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);


    // @Select("select count(*) from ren where username like  contact('%',#{username},'%')")
    @Select("select count(*) from ren")
    Integer selectTotal();//返回查到的总条数，即统计数据表里有多少数据.模糊查询使用contact

}
