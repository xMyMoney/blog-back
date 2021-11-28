package com.zwx.blogback.service;

import com.zwx.blogback.model.BlogConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.Pages;
import com.zwx.blogback.model.req.ReqBlogConfig;
import com.zwx.blogback.model.req.ReqSecret;
import com.zwx.blogback.model.res.ResAboutMe;
import com.zwx.blogback.model.res.ResBlogInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface BlogConfigService extends IService<BlogConfig> {

    ResAboutMe getAbout();

    BlogConfig getMyConfig();

    ResBlogInfo getInfo();

    Boolean checkSecret(ReqSecret secret);

    Boolean updateById(ReqBlogConfig blogConfig);
}
