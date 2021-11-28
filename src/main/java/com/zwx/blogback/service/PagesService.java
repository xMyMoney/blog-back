package com.zwx.blogback.service;

import com.zwx.blogback.model.Pages;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface PagesService extends IService<Pages> {

    Pages getAboutMe();
}
