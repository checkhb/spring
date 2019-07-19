package com.fsl.springbootshiro.persistence.mapper;

import com.fsl.springbootshiro.business.vo.UserConditionVO;
import com.fsl.springbootshiro.persistence.beans.SysUser;
import com.fsl.springbootshiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yudd
 * @date 2019年5月16日14:14:09
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> findPageBreakByCondition(UserConditionVO vo);

    List<SysUser> listByRoleId(Long roleId);

}
