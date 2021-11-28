package com.zwx.blogback.controller.index;


import com.zwx.blogback.model.Article;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.model.res.ResArticleInfo;
import com.zwx.blogback.service.ArticleService;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public RespBean getArticle(Integer id) {
        return RespBean.ok("查找成功",articleService.getDetailArticleById(id));
    }

    @GetMapping("/list")
    public RespBean getListPage(String by,Integer categoryId,Integer tagId,Integer page,Integer pageSize) {
        PageBean<ResArticleInfo> res = articleService.getPage(by,categoryId,tagId,page,pageSize);
        return RespBean.ok("查找成功",res);
    }
    /**@GetMapping("/list")
    public RespBean getListPage(String by,Integer status,Integer page,Integer pageSize) {
        PageBean<Article> res = articleService.getPage(by,status,page,pageSize);
        return RespBean.ok("查找成功",res);
    }*/

    @GetMapping("/archives")
    public RespBean getArchives(Integer page, Integer pageSize) {
        return RespBean.ok("查找成功",articleService.getArchives(page,pageSize));
    }

    @GetMapping("/search")
    public RespBean findArticle(String searchValue,Integer page, Integer pageSize) {
        return RespBean.ok("查找成功",articleService.findByTitleAndBrief(searchValue,page,pageSize));
    }
}

