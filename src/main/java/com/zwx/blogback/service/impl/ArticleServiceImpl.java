package com.zwx.blogback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.blogback.dao.ArticleTagMapperMapper;
import com.zwx.blogback.dao.CategoryMapper;
import com.zwx.blogback.dao.TagMapper;
import com.zwx.blogback.model.*;
import com.zwx.blogback.dao.ArticleMapper;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.req.ReqQueryArticle;
import com.zwx.blogback.model.req.ReqSaveArticle;
import com.zwx.blogback.model.res.*;
import com.zwx.blogback.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.blogback.service.CategoryService;
import com.zwx.blogback.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleTagMapperMapper articleTagMapper;


    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagService tagService;



    @Override
    public ResDetailArticleInfo getDetailArticleById(Integer id) {
        Article article = articleMapper.selectById(id);
        Category category = categoryMapper.selectById(article.getCategoryId());
        QueryWrapper<ArticleTagMapper> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ArticleTagMapper::getArticleId,article.getId());
        List<ArticleTagMapper> tagsId = articleTagMapper.selectList(wrapper);
        List<Tag> tags = new ArrayList<>();
        for (ArticleTagMapper atMapper : tagsId) {
            tags.add(tagMapper.selectById(atMapper.getTagId()));
        }
        //前后文章
        ResSimpleArticle preArticle = articleMapper.selectPreArticleById(article.getId());
        ResSimpleArticle nextArticle = articleMapper.selectNextArticleById(article.getId());
        //更新阅读量
        this.updateById(new Article(article.getId(),article.getPageview() + 1));
        return new ResDetailArticleInfo(article,category,tags,new ResArticleGuide(preArticle,nextArticle));
    }

    @Override
    public ResArticleInfo getArticleById(Integer id) {
        Article article = articleMapper.selectById(id);
        Category category = categoryMapper.selectById(article.getCategoryId());
        QueryWrapper<ArticleTagMapper> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ArticleTagMapper::getArticleId,article.getId());
        List<ArticleTagMapper> tagsId = articleTagMapper.selectList(wrapper);
        List<Tag> tags = new ArrayList<>();
        for (ArticleTagMapper atMapper : tagsId) {
            tags.add(tagMapper.selectById(atMapper.getTagId()));
        }
        return new ResArticleInfo(article,category,tags);
    }

    @Override
    public PageBean<ResArticleInfo> getPage(Integer page, Integer pageSize) {
        List<Article> articles = this.findArticles(null,false,true,page,pageSize);
        List<ResArticleInfo> resArticleInfoList = this.getResArticleInfoList(articles);
        return new PageBean<>(resArticleInfoList.size(),resArticleInfoList);
    }

    @Override
    public Map<String ,Object> getArchives(Integer page, Integer pageSize) {

        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Article::getStatus,0);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        List<ResArticleInfo> resArticleInfoList = this.getResArticleInfoList(articles);
        ResArchivesInfo resArchivesInfo = new ResArchivesInfo(resArticleInfoList);
        Map<String ,Object> map = new HashMap<>();
        //List<ResArticleInfo> list = getPage(page, pageSize).getList();
        //ResArchivesInfo resArchivesInfo = new ResArchivesInfo(list);
        map.put("count",articles.size());
        map.put("list",resArchivesInfo);
        return map;
    }

    @Override
    public PageBean<ResArticleInfo> findByTitleAndBrief(String wd,Integer page, Integer pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("title",wd);
        List<Article> articles = this.findArticles(map, true, false, page, pageSize);
        List<ResArticleInfo> list = getResArticleInfoList(articles);
        return new PageBean<>(list.size(),list);
    }

    @Override
    public PageBean<ResArticleInfo> getPage(String by,Integer categoryId,Integer tagId, Integer page, Integer pageSize) {
        List<Article> articles = null;
        Map<String,Object> map = new HashMap<>();
        if(by != null && !by.equals("")) {
            if(by.equals("category")) {
                map.put("category_id",categoryId);
                articles = this.findArticles(map, true, false, page, pageSize);
            }else {
                articles = articleMapper.findArticlesByTagId(tagId);
            }
        }else {
            articles = this.findArticles(null, true, false, page, pageSize);
        }
        List<ResArticleInfo> resArticleInfoList = this.getResArticleInfoList(articles);
        return new PageBean<>(resArticleInfoList.size(),resArticleInfoList);
    }

    @Override
    public PageBean<Article> getPage(String by, Integer status, Integer page, Integer pageSize) {
        IPage<Article> articleIPage = new Page<>(page,pageSize);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Article::getStatus,status);
        articleMapper.selectPage(articleIPage,queryWrapper);
        List<Article> articles = articleIPage.getRecords();
        return new PageBean<>(articles.size(),articles);
    }

    @Override
    public Boolean updateStatusById(Integer articleId) {
       articleMapper.setStatus(articleId);
        return true;
    }

    @Override
    public List<Article> getArticleByCategoryId(Integer categoryId) {
        Map<String,Object> map = new HashMap<>();
        map.put("category_id",categoryId);
        return findArticles(map,false,false,0,0);
    }

    @Override
    public PageBean<Article> getPage(ReqQueryArticle queryArticle) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        if(queryArticle.getStatus() != null) {
            queryWrapper.lambda().eq(Article::getStatus,queryArticle.getStatus());
        }else if(queryArticle.getCategoryId() != null) {
            queryWrapper.lambda().eq(Article::getCategoryId,queryArticle.getCategoryId());
        }else if(queryArticle.getTagId() != null){
            //处理标签
            queryWrapper.inSql("id","select article_id from article_tag_mapper where tag_id = " + queryArticle.getTagId());
        }
        IPage<Article> articleIPage = new Page<>(queryArticle.getPage(),queryArticle.getPageSize());
        articleMapper.selectPage(articleIPage,queryWrapper);
        return new PageBean<>(articleIPage.getRecords());
    }

    /**
     * 添加文章需要开启事务管理
     * @param articleInfo
     * @return
     */
    @Transactional
    @Override
    public Integer addArticle(ReqSaveArticle articleInfo) {
        Integer articleId = articleInfo.getArticle().getId();
        Article article = articleInfo.getArticle();
        Category category = articleInfo.getCategory();
        List<Tag> tags = articleInfo.getTags();
        if(null == articleId) {
            //新增文章
            //1.处理类别
            //2.处理文章
            //3.处理标签

            //类别
            Integer categoryId = categoryService.saveAndGetId(category);
            article.setCategoryId(String.valueOf(categoryId));
            if(article.getStatus() == 0) {
                article.setPublishTime(new Date());
            }
            this.save(article);
            articleId = articleMapper.getLatestId();

            Boolean flag = tagService.saveListTags(articleId,tags);
        }else {
            //修改文章
            Integer categoryId = categoryService.saveAndGetId(category);
            article.setCategoryId(String.valueOf(categoryId));
            if(article.getStatus() == 2 && null != article.getPublishTime()) {
                article.setStatus((byte) 0);
            }
            if(article.getStatus() == 0 && null == article.getPublishTime()) {
                article.setPublishTime(new Date());
            }

            this.updateById(article);
            //标签还不能修改
            Boolean flag = tagService.saveListTags(articleId,tags);
        }
        return articleId;
    }

    @Override
    public boolean updateCategory(Integer categoryId) {
        return articleMapper.updateCategoryId(categoryId) > 0;
    }

    /**
     * 获取Article列表
     * @param fw 查询内容
     * @param isLike 是否模糊查询
     * @param sort true为升序 false为降序（默认按发表时间排序）
     * @param curPage 当前页
     * @param pageSize  页大小
     * @return
     */
    private List<Article> findArticles(Map<String,Object> fw,Boolean isLike,Boolean sort,Integer curPage,Integer pageSize) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        if (null != fw) {
            if(isLike) {
                for (String column : fw.keySet()) {
                    queryWrapper.like(column,fw.get(column));
                }
            }else {
                for (String column : fw.keySet()) {
                    queryWrapper.eq(column,fw.get(column));
                }
            }
        }
        queryWrapper.lambda().orderBy(true,sort,Article::getPublishTime);
        IPage<Article> articleIPage;
        if(curPage == 0 && pageSize == 0) {
            articleIPage = new Page<>();
        }else {
            articleIPage = new Page<>(curPage,pageSize);
        }
        articleMapper.selectPage(articleIPage,queryWrapper);
        return articleIPage.getRecords();
    }

    /**
     * 拼装数据 List<ResArticleInfo>
     * @param articles
     * @return
     */
    private List<ResArticleInfo> getResArticleInfoList(List<Article> articles) {
        List<ResArticleInfo> resArticleInfoList = new ArrayList<>();
        for (Article article : articles) {
            ResArticleInfo resArticleInfo = new ResArticleInfo();
            resArticleInfo.setArticle(article);

            Category category = categoryMapper.selectById(article.getCategoryId());
            resArticleInfo.setCategory(category);

            QueryWrapper<ArticleTagMapper> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(ArticleTagMapper::getArticleId,article.getId());
            List<ArticleTagMapper> tagsId = articleTagMapper.selectList(wrapper);
            List<Tag> tags = new ArrayList<>();
            for (ArticleTagMapper atMapper : tagsId) {
                tags.add(tagMapper.selectById(atMapper.getTagId()));
            }
            resArticleInfo.setTags(tags);

            resArticleInfoList.add(resArticleInfo);
        }
        return resArticleInfoList;
    }

    /**
     * 返回最新创建的文章id
     * @return
     */
    private Integer getNewArticleId() {
        return articleMapper.getLatestId();
    }
}
