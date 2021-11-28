package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/statistics")
public class AdminHomeMsgController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/home")
    public RespBean getStatistics() {
        return RespBean.ok("查找成功",statisticsService.getStatistics());
    }
}
