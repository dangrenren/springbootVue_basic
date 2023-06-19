package com.example.spring_basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_basic.entity.Files;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper extends BaseMapper<Files> {


}
