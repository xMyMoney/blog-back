package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.Article;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.model.req.ReqQueryArticle;
import com.zwx.blogback.model.req.ReqSaveArticle;

import com.zwx.blogback.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/article")
public class SysArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public RespBean getList(String by,Integer status,Integer page,Integer pageSize) {
//        PageBean<Article> res = articleService.getPage(by,status,page,pageSize);
//        return RespBean.ok("查找成功",res);
//    }

    @GetMapping("/list")
    public RespBean getList(ReqQueryArticle queryArticle) {
        PageBean<Article> res = articleService.getPage(queryArticle);
        return RespBean.ok("查找成功",res);
    }

    @GetMapping("/list/category")
    public RespBean getListByCategoryId(Integer categoryId) {
        return RespBean.ok("查找成功",articleService.getArticleByCategoryId(categoryId));
    }

    @GetMapping
    public RespBean findById(Integer id) {
        return RespBean.ok("查找成功",articleService.getArticleById(id));
    }


//    @PostMapping
//    public RespBean push(TestArticle article) {
//        //return RespBean.ok("添加成功",articleService.publishArticle(article));
//        System.out.println(article);
//        return null;
//    }

    @PostMapping
    public RespBean push(@RequestBody ReqSaveArticle article) {
        //return RespBean.ok("添加成功",articleService.publishArticle(article));
        System.out.println(article);
        Integer id = articleService.addArticle(article);
        return RespBean.ok("添加成功",id);
    }

    @DeleteMapping
    public RespBean del(Integer articleId) {
        Boolean flag = articleService.updateStatusById(articleId);
        return null;
    }
}
