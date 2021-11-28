package com.zwx.blogback.service;

import com.zwx.blogback.model.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.res.ResComments;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface CommentsService extends IService<Comments> {

    PageBean<Comments> findByArticleId(Integer articleId);

    PageBean<ResComments> getComments(Integer articleId);
}
