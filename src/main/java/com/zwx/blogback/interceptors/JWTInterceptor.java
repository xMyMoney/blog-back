package com.zwx.blogback.interceptors;

import com.auth0.jwt.exceptions.*;
import com.zwx.blogback.exception.BusinessException;
import com.zwx.blogback.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Chilly Cui on 2020/9/9.
 */
public class JWTInterceptor implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){

        //获取请求头中的令牌
        String token = request.getHeader("token");

        log.info("请求方法"+request.getMethod());
        log.info("请求方法"+request.getRequestURI());
        log.info("请求方法"+request.getMethod()+"请求头 token>>>>>>>>"+ request.getHeader("token"));
        if(null == token) {
            throw new BusinessException(201,"未登录");
        }
        try {
            JWTUtils.verify(token);
            return true;
        }catch (TokenExpiredException e) {
            throw new BusinessException(201,"登录信息已过期");
        }catch (JWTVerificationException e) {
            throw new BusinessException(201,"登录信息不合法");
        }
        //return true;
    }
}
