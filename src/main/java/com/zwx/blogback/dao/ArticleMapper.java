package com.zwx.blogback.dao;

import com.zwx.blogback.model.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.blogback.model.res.ResSimpleArticle;
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
public interface ArticleMapper extends BaseMapper<Article> {

    ResSimpleArticle selectPreOrNextArticleById(Integer id);

    ResSimpleArticle selectPreArticleById(Integer id);

    ResSimpleArticle selectNextArticleById(Integer id);

    List<Article> findArticlesByTagId(Integer tagId);

    Integer countByStatusInteger(Integer status);

    Integer getLatestId();

    Integer setStatus(Integer articleId);

    Integer updateCategoryId(Integer categoryId);
}
