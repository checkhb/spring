package com.fsl.springbootspringsession.service;

import com.fsl.springbootspringsession.entity.User;
import com.fsl.springbootspringsession.util.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    public ServiceResult login(User user){
        /**
         * 在这里省略了数据库或者缓存校验数据的功能
         */
        if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
            return ServiceResult.success(user);
        }else{
            return ServiceResult.failure("400","用户名或密码错误");
        }
    }
}
