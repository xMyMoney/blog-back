package com.zwx.blogback;

import com.zwx.blogback.utils.AliOssUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTest {

    @Autowired
    private AliOssUtils aliOssUtils;

    @Test
    void getToken() {
        System.out.println(aliOssUtils.getToken());
    }
}
