package com.zwx.blogback;

import com.zwx.blogback.dao.ArticleMapper;
import com.zwx.blogback.model.Article;
import com.zwx.blogback.model.Category;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.res.ResArchivesInfo;
import com.zwx.blogback.model.res.ResArticleInfo;
import com.zwx.blogback.model.res.ResComments;
import com.zwx.blogback.service.ArticleService;
import com.zwx.blogback.service.CategoryService;
import com.zwx.blogback.service.CommentsService;
import com.zwx.blogback.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class BlogBackApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentsService commentsService;


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    @Transactional
    @Test
    void addCategory() {
        //System.out.println(categoryService.);
        System.out.println(categoryService.save(new Category("测试")));
        System.out.println(tagService.removeById(15));
        System.out.println(">>>");
    }

    @Test
    void  getComments() {
        List<ResComments> resComments = commentsService.getComments(1).getList();
        for (ResComments comments : resComments) {
            System.out.println("???");
            System.out.println(comments);
            System.out.println(comments.getChildren());
        }
    }

    @Test
    void contextLoads() {
        /**PageBean<ResArticleInfo> page = articleService.getPage(1, 5);
        ResArchivesInfo resArchivesInfo = new ResArchivesInfo(page.getList());
        Map<Integer, Map<Integer, List<ResArticleInfo>>> yearMap = resArchivesInfo.getYearMap();
        for (Integer year : yearMap.keySet()) {
            System.out.println(year);
            Map<Integer, List<ResArticleInfo>> monthMap = yearMap.get(year);
            for (Integer month : monthMap.keySet()) {
                System.out.println(month+"月");
                System.out.println(monthMap.get(month));
            }
        }*/
        PageBean<ResArticleInfo> page = articleService.getPage(1, 5);
        List<ResArticleInfo> list = page.getList();
        Map<Integer,Map<Integer,List<ResArticleInfo>>> data = new HashMap<>();

        Map<Integer,List<ResArticleInfo>> monthMap = new HashMap<>();
        List<ResArticleInfo> articleInfoList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();


        for (ResArticleInfo articleInfo : list) {
            calendar.setTime(articleInfo.getArticle().getPublishTime());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            if(!data.containsKey(year)) {
                monthMap = new HashMap<>();
            }
            if(!monthMap.containsKey(month)) {
                articleInfoList = new ArrayList<>();
            }
            articleInfoList.add(articleInfo);
            monthMap.put(month,articleInfoList);
            data.put(year,monthMap);
        }

        for (Integer y : data.keySet()) {
            System.out.println(y);
            Map<Integer, List<ResArticleInfo>> mon = data.get(y);
            for (Integer m : mon.keySet()) {
                System.out.println(m+"月");
                for (ResArticleInfo articleInfo : mon.get(m)) {
                    System.out.println(articleInfo);
                }
            }
        }
    }

}
