package com.zwx.blogback.handler;

import com.zwx.blogback.exception.BusinessException;
import com.zwx.blogback.model.common.RespBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * java运行异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e) {
        e.printStackTrace();
        return RespBean.error("系统出错");
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public RespBean BusinessExceptionHandler(BusinessException e) {
        if(!StringUtils.isBlank(e.getLocalizedMessage())) {
            return RespBean.error("操作异常");
        }
        return RespBean.error(e.getCode(),e.getMsg());
    }
}
