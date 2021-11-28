package com.zwx.blogback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.blogback.dao.*;
import com.zwx.blogback.model.BlogConfig;
import com.zwx.blogback.model.Pages;
import com.zwx.blogback.model.req.ReqBlogConfig;
import com.zwx.blogback.model.req.ReqSecret;
import com.zwx.blogback.model.res.ResAboutMe;
import com.zwx.blogback.model.res.ResBlogInfo;
import com.zwx.blogback.service.BlogConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Service
public class BlogConfigServiceImpl extends ServiceImpl<BlogConfigMapper, BlogConfig> implements BlogConfigService {

    @Autowired
    private PagesMapper pagesMapper;

    @Autowired
    private BlogConfigMapper blogConfigMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public ResAboutMe getAbout() {
        return new ResAboutMe(pagesMapper.selectOne(null).getHtml());
    }

    @Override
    public BlogConfig getMyConfig() {
        return  blogConfigMapper.getInfo();
    }

    @Override
    public ResBlogInfo getInfo() {
        BlogConfig info = blogConfigMapper.getInfo();
        Integer articleCount = articleMapper.countByStatusInteger(0);
        Integer categoryCount = categoryMapper.countByStatusInteger(0);
        Integer tagCount = tagMapper.countByStatusInteger(0);
        return new ResBlogInfo(info.getBlogName(),info.getSign(),info.getAvatar(),articleCount,categoryCount,tagCount);
    }

    @Override
    public Boolean checkSecret(ReqSecret secret) {
        QueryWrapper<BlogConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogConfig::getViewPassword,secret.getKey());
        BlogConfig blogConfig = this.getOne(queryWrapper);
        return null != blogConfig;
    }

    @Override
    public Boolean updateById(ReqBlogConfig blogConfig) {
        BlogConfig config = new BlogConfig();
        config.setId(blogConfig.getId());
        config.setBlogName(blogConfig.getBlogName());
        config.setAvatar(blogConfig.getAvatar());
        config.setSign(blogConfig.getSign());
        config.setGithub(blogConfig.getGithub());
        config.setWxpayQrcode(blogConfig.getWxpayQrcode());
        config.setAlipayQrcode(blogConfig.getAlipayQrcode());
        if(blogConfig.getSettingPassword()) {
            QueryWrapper<BlogConfig> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(BlogConfig::getViewPassword,blogConfig.getOldPassword());
            if(null == this.getOne(queryWrapper)) {
                return false;
            }
            config.setViewPassword(blogConfig.getNewPassword());
        }
        return this.updateById(config);
    }

}
