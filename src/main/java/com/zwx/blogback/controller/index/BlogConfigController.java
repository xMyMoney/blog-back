package com.zwx.blogback.controller.index;


import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.model.req.ReqSecret;
import com.zwx.blogback.service.BlogConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@RestController
@RequestMapping("/me")
public class BlogConfigController {

    @Autowired
    private BlogConfigService blogConfigService;

    @GetMapping("/about")
    public RespBean getAbout() {
        return RespBean.ok("查找成功",blogConfigService.getAbout());
    }

    @GetMapping("/blogInfo")
    public RespBean getInfo() {
        return RespBean.ok("查找成功",blogConfigService.getInfo());
    }

    @PostMapping("/testSecret")
    public RespBean testSecret(@RequestBody ReqSecret secret) {
        return RespBean.ok("密码正确",blogConfigService.checkSecret(secret));
    }
}

