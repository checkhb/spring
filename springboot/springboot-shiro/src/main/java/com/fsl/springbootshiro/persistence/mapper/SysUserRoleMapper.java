package com.fsl.springbootshiro.persistence.mapper;

import com.fsl.springbootshiro.persistence.beans.SysUserRole;
import com.fsl.springbootshiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yudd
 * @date 2019年5月16日14:13:45
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    List<Integer> findUserIdByRoleId(Integer roleId);

}
