package com.fsl.springbootshiro.persistence.mapper;

import com.fsl.springbootshiro.business.vo.RoleConditionVO;
import com.fsl.springbootshiro.persistence.beans.SysRole;
import com.fsl.springbootshiro.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yudd
 * @date 2019年5月16日14:13:12
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<SysRole> findPageBreakByCondition(RoleConditionVO vo);

    /**
     * 该节代码参考自http://blog.csdn.net/poorcoder_/article/details/71374002
     * 感谢网友
     *
     * @param userId
     * @return
     */
    List<SysRole> queryRoleListWithSelected(Integer userId);

    List<SysRole> listRolesByUserId(Long userId);
}
