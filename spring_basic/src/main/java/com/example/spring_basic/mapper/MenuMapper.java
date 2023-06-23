package com.example.spring_basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_basic.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 青哥哥
 * @since 2022-02-10
 *
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
