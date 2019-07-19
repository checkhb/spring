package com.fsl.springbootshiro.business.service;


import com.fsl.springbootshiro.business.entity.UserRole;
import com.fsl.springbootshiro.framework.object.AbstractService;

/**
 * 用户角色
 *
 */
public interface SysUserRoleService extends AbstractService<UserRole, Long> {

    /**
     * 添加用户角色
     *
     * @param userId
     * @param roleIds
     */
    void addUserRole(Long userId, String roleIds);

    /**
     * 根据用户ID删除用户角色
     *
     * @param userId
     */
    void removeByUserId(Long userId);
}
