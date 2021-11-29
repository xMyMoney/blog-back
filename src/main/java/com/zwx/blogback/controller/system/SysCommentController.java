package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/comments")
public class SysCommentController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/list")
    public RespBean getList() {
        return RespBean.ok("查找成功",new PageBean<>(commentsService.list()));
    }

    @GetMapping
    public RespBean getComments(Integer articleId) {
        return RespBean.ok("查找成功",commentsService.getComments(articleId));
    }


}
