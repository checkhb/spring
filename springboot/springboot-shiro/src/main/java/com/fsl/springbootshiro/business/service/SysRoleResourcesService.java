package com.fsl.springbootshiro.business.service;


import com.fsl.springbootshiro.business.entity.RoleResources;
import com.fsl.springbootshiro.framework.object.AbstractService;

/**
 * 角色资源
 *
 */
public interface SysRoleResourcesService extends AbstractService<RoleResources, Long> {

    /**
     * 添加角色资源
     *
     * @param roleId
     * @param resourcesIds
     */
    void addRoleResources(Long roleId, String resourcesIds);

    /**
     * 通过角色id批量删除
     *
     * @param roleId
     */
    void removeByRoleId(Long roleId);
}
