package com.fsl.springbootjwt.service;

import com.fsl.springbootjwt.entity.ManagerInfo;
import com.fsl.springbootjwt.entity.SysRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 后台用户管理
 */

@Service
public class ManagerInfoService {

    /**
     * 通过名称查找用户
     * 这里我直接写常量，实际生产环境会通过DAO访问数据库
     *
     * @param username
     * @return
     */
    public ManagerInfo findByUsername(String username) {

        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setUsername(username);
        managerInfo.setPids("1,2,3");
        managerInfo.setPidsList(Arrays.asList(1, 2, 3));
        managerInfo.setPnames("第1个,第2个");
        managerInfo.setState(1);
        managerInfo.setCreatedTime(new Date());
        managerInfo.setName("系统管理员");
        // 随机数
        managerInfo.setSalt("ef748186673033723bbf4e056f4ec92e");
        managerInfo.setPassword("75fd1c5eaf64f4c5f24b9fcca1230140");
        List<SysRole> roles = new ArrayList<>();
        SysRole role = new SysRole();
        role.setId(1);
        role.setRole("admin");
        role.setDescription("超级管理员");
        roles.add(role);
        managerInfo.setRoles(roles);
        return managerInfo;
    }

}
