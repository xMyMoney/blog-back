package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.Category;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
public class SysCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public RespBean getList() {
        return RespBean.ok("查找成功",new PageBean<>(categoryService.getCategoryList()));
    }

    @GetMapping
    public RespBean getName(Integer categoryId) {
        return RespBean.ok("查找成功",categoryService.getById(categoryId).getName());
    }

    @PostMapping
    public RespBean addCategory(String categoryName) {
        return categoryService.save(new Category(categoryName)) ? RespBean.ok("添加成功") : RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updateCategory(Category category) {
        return categoryService.updateById(category) ? RespBean.ok("修改成功") : RespBean.error("修改失败");
    }

    @DeleteMapping
    public RespBean deleteCategory(Integer categoryId) {
        return categoryService.updateStatusById(categoryId) ? RespBean.ok("删除成功") : RespBean.error("删除失败");
    }
}
