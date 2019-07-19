package com.fsl.springbootjwt.controller;

import com.fsl.springbootjwt.util.ServiceResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sj2
 * 机具管理API接口类
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    /**
     * 入网绑定查询接口
     *
     * @return 是否入网
     */
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    @RequiresAuthentication
    public ServiceResult join(@RequestParam("imei") String imei) {
        logger.info("入网查询接口 start... imei=" + imei);
        return ServiceResult.success("已入网并绑定了网点");
    }
}
