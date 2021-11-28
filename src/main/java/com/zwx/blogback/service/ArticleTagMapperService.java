package com.zwx.blogback.service;

import com.zwx.blogback.model.ArticleTagMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.Tag;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface ArticleTagMapperService extends IService<ArticleTagMapper> {
    /**
     * 根据标签id获取相应文章id
     * @param tagId
     * @return
     */
    List<Integer> getArticleIdList(Integer tagId);

    boolean removeByTagId(Integer tagId);

    boolean isExist(Integer articleId, Integer tagId);

    List<Integer> getTagListByArticleId(Integer articleId);

    Boolean delete(Integer articleId, Integer tagId);
}
