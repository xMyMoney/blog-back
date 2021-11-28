package com.zwx.blogback.controller.index;


import com.zwx.blogback.model.Comments;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping
    public RespBean getComments(Integer articleId) {
        return RespBean.ok("查找成功",commentsService.getComments(articleId));
    }

    @PostMapping
    public RespBean addComments(Comments comment) {
        System.out.println(comment);
        commentsService.save(comment);
        return null;
    }

}

