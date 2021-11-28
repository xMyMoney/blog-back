package com.zwx.blogback.dao;

import com.zwx.blogback.model.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.blogback.model.res.ResTag;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    Integer countByStatusInteger(Integer status);

    Integer getLatestId();

    List<ResTag> selectList();
}
