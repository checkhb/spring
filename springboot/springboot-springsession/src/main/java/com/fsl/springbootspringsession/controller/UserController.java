package com.fsl.springbootspringsession.controller;


import com.alibaba.fastjson.JSON;
import com.fsl.springbootspringsession.entity.User;
import com.fsl.springbootspringsession.service.UserService;
import com.fsl.springbootspringsession.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    /**
     * 登录URL
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public ServiceResult login(@RequestBody User user, HttpSession session){
        ServiceResult serviceResult = userService.login(user);
        if(serviceResult.isSuccess()){
            logger.info("session id = " + session.getId());
            session.setAttribute(session.getId(), JSON.toJSONString(serviceResult.getResult()));
        }
        return serviceResult;
    }


    /**
     * 登出URL
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout")
    public ServiceResult logout(HttpSession session){
        logger.info("session id = " + session.getId());
        session.removeAttribute(session.getId());
        return ServiceResult.success("user logout success");
    }


    /**
     * 模拟一个普通的URL请求
     * @return
     */
    @ResponseBody
    @RequestMapping("/get")
    public ServiceResult get(){
        User user= new User();
        user.setUsername("kobe bryant");
        user.setPassword("I Love Los Angeles Lakers");
        return ServiceResult.success(user);
    }

}
