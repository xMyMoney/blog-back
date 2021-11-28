package com.zwx.blogback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.blogback.model.Comments;
import com.zwx.blogback.dao.CommentsMapper;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.res.ResComments;
import com.zwx.blogback.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public PageBean<Comments> findByArticleId(Integer articleId) {
        QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Comments::getArticleId,articleId);
        return null;
    }

    @Override
    public PageBean<ResComments> getComments(Integer articleId) {
        List<Comments> parentList = commentsMapper.getParentList(articleId);
        List<ResComments> resComments = new ArrayList<>();
        for (Comments comment : parentList) {
            ResComments comments = new ResComments();
            comments.setId(comment.getId());
            comments.setName(comment.getName());
            comments.setAvatar("");
            comments.setCreateTime(comment.getCreateTime());
            comments.setContent(comment.getContent());
            comments.setChildren(commentsMapper.getChildrenList(comment.getArticleId(),comment.getId()));
            resComments.add(comments);
        }
        return new PageBean<>(resComments);
    }
}
