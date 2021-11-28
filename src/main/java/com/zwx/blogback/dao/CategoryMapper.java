package com.zwx.blogback.dao;

import com.zwx.blogback.model.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.blogback.model.res.ResCategory;
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
public interface CategoryMapper extends BaseMapper<Category> {

    Integer countByStatusInteger(Integer status);

    Integer getLatestId();

    Integer updateArticleCount(Integer categoryId);

    List<ResCategory> selectList();
}
