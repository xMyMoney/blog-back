package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.BlogConfig;
import com.zwx.blogback.model.Pages;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.model.req.ReqBlogConfig;
import com.zwx.blogback.model.res.ResAboutMe;
import com.zwx.blogback.service.BlogConfigService;
import com.zwx.blogback.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/webConfig")
public class SysBlogConfigController {

    @Autowired
    private BlogConfigService blogConfigService;

    @Autowired
    private PagesService pagesService;

    @GetMapping
    public RespBean getBlogConfig() {
        BlogConfig blogConfig = blogConfigService.getMyConfig();
        return RespBean.ok("查找成功",blogConfig);
    }

    @GetMapping("/me")
    public RespBean getAboutMe() {
        Pages about = pagesService.getAboutMe();
        return RespBean.ok("查找成功",about);
    }

    @PostMapping("/check")
    public RespBean checkPassword(Integer id,String oldPassword,String newPassword) {
        return RespBean.ok("");
    }

    @PutMapping("/me")
    public RespBean updateAboutMe(ReqBlogConfig blogConfig) {
        return blogConfigService.updateById(blogConfig) ? RespBean.ok("更新成功") : RespBean.error("密码错误");
    }



    @PutMapping("/about")
    public RespBean updateAboutMe(Pages about) {
        pagesService.updateById(about);
        return RespBean.ok("更新成功");
    }
}
