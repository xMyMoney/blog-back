package com.zwx.blogback.config;

import com.zwx.blogback.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Chilly Cui on 2020/9/9.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new JWTInterceptor())
//                .addPathPatterns("/api/user/**")
//                .excludePathPatterns("/api/user/login")
//        ;
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
        ;
    }
}
