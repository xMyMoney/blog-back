package com.zwx.blogback.dao;

import com.zwx.blogback.model.Pages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Mapper
public interface PagesMapper extends BaseMapper<Pages> {

    Pages getInfo();
}
