package com.zwx.blogback.dao;

import com.zwx.blogback.model.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
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
public interface AdminMapper extends BaseMapper<Admin> {
}
