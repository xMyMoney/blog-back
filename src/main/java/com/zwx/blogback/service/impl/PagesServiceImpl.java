package com.zwx.blogback.service.impl;

import com.zwx.blogback.model.Pages;
import com.zwx.blogback.dao.PagesMapper;
import com.zwx.blogback.service.PagesService;
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
public class PagesServiceImpl extends ServiceImpl<PagesMapper, Pages> implements PagesService {

    @Autowired
    private PagesMapper pagesMapper;

    @Override
    public Pages getAboutMe() {
        return pagesMapper.getInfo();
    }
}
