package com.zwx.blogback.service;

import com.zwx.blogback.model.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.res.ResCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface CategoryService extends IService<Category> {

    boolean updateStatusById(Integer categoryId);

    Integer saveAndGetId(Category category);

    List<ResCategory> getCategoryList();
}
