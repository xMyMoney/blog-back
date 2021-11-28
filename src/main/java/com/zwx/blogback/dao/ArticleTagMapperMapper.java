package com.zwx.blogback.dao;

import com.zwx.blogback.model.ArticleTagMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.blogback.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface ArticleTagMapperMapper extends BaseMapper<ArticleTagMapper> {

    Integer delByTagId(Integer tagId);

    Integer findByArticleIdAndTagId(@Param("articleId") Integer articleId,@Param("tagId") Integer tagId);

    List<Integer> findTagListByArticleId(Integer articleId);

    Integer delByArticleIdAndTagId(@Param("articleId")Integer articleId,@Param("tagId") Integer tagId);

}
