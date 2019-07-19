package com.fsl.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fsl.dubboapi.service.UserService;
import com.fsl.dubboconsumer.dto.ServiceResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Reference(version = "${demo.service.version}")
    private UserService userService;

    @ResponseBody
    @GetMapping("/getUser")
    public ServiceResult getUser(){
        return ServiceResult.success(userService.getUser());
    }
}
