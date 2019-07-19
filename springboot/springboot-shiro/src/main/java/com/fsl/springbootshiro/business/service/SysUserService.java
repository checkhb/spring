package com.fsl.springbootshiro.business.service;



import com.fsl.springbootshiro.business.entity.User;
import com.fsl.springbootshiro.business.vo.UserConditionVO;
import com.fsl.springbootshiro.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 用户
 *
 */
public interface SysUserService extends AbstractService<User, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<User> findPageBreakByCondition(UserConditionVO vo);

    /**
     * 更新用户最后一次登录的状态信息
     *
     * @param user
     * @return
     */
    User updateUserLastLoginInfo(User user);

    /**
     * 根据用户名查找
     *
     * @param userName
     * @return
     */
    User getByUserName(String userName);

    /**
     * 通过角色Id获取用户列表
     *
     * @param roleId
     * @return
     */
    List<User> listByRoleId(Long roleId);

}
