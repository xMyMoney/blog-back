package com.zwx.blogback.controller.system;

import com.zwx.blogback.utils.AliOssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class AliOssController {

    @Autowired
    private AliOssUtils aliOssUtils;

    @GetMapping
    public Object getToken() {
        return aliOssUtils.getToken();
    }

}
