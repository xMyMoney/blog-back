package com.zwx.blogback.controller.index;


import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public RespBean getList() {
        return RespBean.ok("查找成功",tagService.getTagList());
    }
}

