package com.zwx.blogback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.blogback.model.Admin;
import com.zwx.blogback.dao.AdminMapper;
import com.zwx.blogback.model.req.ReqLoginAdmin;
import com.zwx.blogback.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.blogback.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String login(ReqLoginAdmin loginAdmin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Admin::getUsername,loginAdmin.getUsername())
                .eq(Admin::getPassword,loginAdmin.getPassword());
        Admin admin = adminMapper.selectOne(queryWrapper);
        Map<String, String> payload = new HashMap<>();
        payload.put("id", admin.getUserId().toString());
        payload.put("name", admin.getUsername());
        return JWTUtils.getToken(payload);
    }
}
