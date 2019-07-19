package com.fsl.jpa.controller;

import com.fsl.jpa.dto.UserDto;
import com.fsl.jpa.service.UserService;
import com.fsl.jpa.util.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public ServiceResult save(){
        UserDto userDto = new UserDto();
        userDto.setId(1005L);
        userDto.setAccount("777777777@qq.com");
        userDto.setName("thales");
        userDto.setPwd("123456");
        userService.save(userDto);
        return ServiceResult.success("success");
    }

    @RequestMapping("/get/{id}")
    public ServiceResult get(@PathVariable Long id){
        return ServiceResult.success(userService.get(id));
    }

    @RequestMapping("/update/{id}")
    public ServiceResult update(@PathVariable Long id){
        userService.update(id);
        return ServiceResult.success("success");

    }

    @RequestMapping("/delete/{id}")
    public ServiceResult delete(@PathVariable Long id){
        userService.delete(id);
        return ServiceResult.success("success");
    }
}
