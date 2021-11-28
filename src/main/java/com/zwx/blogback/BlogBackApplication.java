package com.zwx.blogback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BlogBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackApplication.class, args);
    }

}
