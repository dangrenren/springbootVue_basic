package com.example.spring_basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_basic.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select id from role where flag = #{flag}")
    Integer selectByFlag(@Param("flag") String flag);
}
