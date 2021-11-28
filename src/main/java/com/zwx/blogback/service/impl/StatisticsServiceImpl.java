package com.zwx.blogback.service.impl;

import com.zwx.blogback.dao.ArticleMapper;
import com.zwx.blogback.dao.CategoryMapper;
import com.zwx.blogback.dao.CommentsMapper;
import com.zwx.blogback.dao.TagMapper;
import com.zwx.blogback.model.res.ResBlogMessageCards;
import com.zwx.blogback.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private CommentsMapper commentsMapper;



    @Override
    public ResBlogMessageCards getStatistics() {
        int publishCount = articleMapper.countByStatusInteger(0);
        int draftsCount = articleMapper.countByStatusInteger(2);
        int deletedCount = articleMapper.countByStatusInteger(1);
        int categoryCount = categoryMapper.countByStatusInteger(0);
        int tagCount = tagMapper.countByStatusInteger(0);
        int commentsCount = commentsMapper.countByStatusInteger(0);
        return new ResBlogMessageCards(publishCount,draftsCount,deletedCount,categoryCount,tagCount,commentsCount);
    }
}
