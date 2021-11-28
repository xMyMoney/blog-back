package com.zwx.blogback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.blogback.model.ArticleTagMapper;
import com.zwx.blogback.dao.ArticleTagMapperMapper;
import com.zwx.blogback.model.Tag;
import com.zwx.blogback.service.ArticleTagMapperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Service
public class ArticleTagMapperServiceImpl extends ServiceImpl<ArticleTagMapperMapper, ArticleTagMapper> implements ArticleTagMapperService {

    @Autowired
    private ArticleTagMapperMapper articleTagMapper;

    @Override
    public List<Integer> getArticleIdList(Integer tagId) {
        QueryWrapper<ArticleTagMapper> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ArticleTagMapper::getTagId,tagId);
        
        return null;
    }

    @Override
    public boolean removeByTagId(Integer tagId) {
        Integer row = articleTagMapper.delByTagId(tagId);
        return true;
    }

    @Override
    public boolean isExist(Integer articleId, Integer tagId) {
        return articleTagMapper.findByArticleIdAndTagId(articleId,tagId) == 1;
    }

    @Override
    public List<Integer> getTagListByArticleId(Integer articleId) {
        return articleTagMapper.findTagListByArticleId(articleId);
    }

    @Override
    public Boolean delete(Integer articleId, Integer tagId) {
        return articleTagMapper.delByArticleIdAndTagId(articleId,tagId) == 1;
    }


}
