package com.zwx.blogback.service;

import com.zwx.blogback.model.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.req.ReqLoginAdmin;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface AdminService extends IService<Admin> {

    String login(ReqLoginAdmin loginAdmin);
}
