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
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){

        //获取请求头中的令牌
        String token = request.getHeader("token");
        //log.info("当前token为：{}", token);
//        if(null == token) {
//            throw new NullPointerException("token为空");
//        }
//
//        try {
//            JWTUtils.verify(token);
//            return true;
//        } catch (SignatureVerificationException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("签名不一致");
//        } catch (TokenExpiredException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("令牌过期");
//        } catch (AlgorithmMismatchException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("算法不匹配");
//        } catch (InvalidClaimException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("失效的payload");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            throw new RuntimeException("token无效");
//        }

        if(null == token) {
            throw new BusinessException("未登录");
        }
        try {
            JWTUtils.verify(token);
            return true;
        }catch (TokenExpiredException e) {
            throw new BusinessException("登录信息已过期");
        }catch (JWTVerificationException e) {
            throw new BusinessException("登录信息不合法");
        }
    }
}
