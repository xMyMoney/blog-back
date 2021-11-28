package com.zwx.blogback.service;

import com.zwx.blogback.model.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.req.ReqQueryArticle;
import com.zwx.blogback.model.req.ReqSaveArticle;
import com.zwx.blogback.model.res.ResArticleInfo;
import com.zwx.blogback.model.res.ResDetailArticleInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface ArticleService extends IService<Article> {

    ResDetailArticleInfo getDetailArticleById(Integer id);
    ResArticleInfo getArticleById(Integer id);

    PageBean<ResArticleInfo> getPage(Integer page, Integer pageSize);

    Map<String ,Object>  getArchives(Integer page, Integer pageSize);

    PageBean<ResArticleInfo> findByTitleAndBrief(String wd,Integer page, Integer pageSize);

    PageBean<ResArticleInfo> getPage(String by,Integer categoryId,Integer tagId, Integer page, Integer pageSize);

    PageBean<Article> getPage(String by, Integer status, Integer page, Integer pageSize);

    Boolean updateStatusById(Integer articleId);

    List<Article> getArticleByCategoryId(Integer categoryId);

    PageBean<Article> getPage(ReqQueryArticle queryArticle);

    Integer addArticle(ReqSaveArticle articleInfo);

    boolean updateCategory(Integer categoryId);
}
