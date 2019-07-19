package com.fsl.springbootjwt.controller;

import com.fsl.springbootjwt.entity.LoginParam;
import com.fsl.springbootjwt.entity.ManagerInfo;
import com.fsl.springbootjwt.service.ManagerInfoService;
import com.fsl.springbootjwt.util.JWTUtil;
import com.fsl.springbootjwt.util.ServiceResult;
import com.fsl.springbootjwt.util.ShiroUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sj2
 * 登录接口类
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ManagerInfoService managerInfoService;


    /**
     * 对应的用户名和密码为：admin/12345678
     * @param contentType
     * @param loginParam
     * @return
     */
    @PostMapping("/login")
    public ServiceResult login(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                               @RequestBody LoginParam loginParam) {
        logger.info("用户请求登录获取Token");
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        ManagerInfo user = managerInfoService.findByUsername(username);
        //随机数盐
        String salt = user.getSalt();
        //原密码加密（通过username + salt作为盐）
        String encodedPassword = ShiroUtil.md5(password, username + salt);
        logger.info("encodedPassword = " + encodedPassword);
        if (user.getPassword().equals(encodedPassword)) {
            return ServiceResult.success(JWTUtil.sign(username, encodedPassword));
        } else {
            throw new UnauthorizedException();
        }
    }

}
