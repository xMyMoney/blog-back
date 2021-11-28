package com.zwx.blogback;

import com.zwx.blogback.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void getList() {
        categoryService.getCategoryList().forEach(System.out::println);
    }
}
