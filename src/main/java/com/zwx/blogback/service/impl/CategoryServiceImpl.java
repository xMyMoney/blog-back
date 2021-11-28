package com.zwx.blogback.service.impl;

import com.zwx.blogback.model.Category;
import com.zwx.blogback.dao.CategoryMapper;
import com.zwx.blogback.model.res.ResCategory;
import com.zwx.blogback.service.ArticleService;
import com.zwx.blogback.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleService articleService;

    @Transactional
    @Override
    public boolean updateStatusById(Integer categoryId) {
        //更新分类状态
        categoryMapper.updateById(new Category(categoryId,true));
        //更新文章分类id
        return articleService.updateCategory(categoryId);
    }

    @Transactional
    @Override
    public Integer saveAndGetId(Category category) {
        if(null != category.getName()) {
            this.save(category);
            return categoryMapper.getLatestId();
        }
        return category.getId();
    }

    @Override
    public List<ResCategory> getCategoryList() {
        return categoryMapper.selectList();
    }
}
