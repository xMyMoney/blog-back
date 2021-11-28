package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.model.req.ReqLoginAdmin;
import com.zwx.blogback.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public RespBean login(ReqLoginAdmin loginAdmin) {
        String token = adminService.login(loginAdmin);
        return RespBean.ok("登录成功",token);
    }
}
