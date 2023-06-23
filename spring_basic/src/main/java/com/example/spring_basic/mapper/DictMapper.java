package com.example.spring_basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_basic.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {
}
