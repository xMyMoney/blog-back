package com.zwx.blogback;

import com.zwx.blogback.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Test
    void getList() {
        tagService.getTagList().forEach(System.out::println);
    }
}
