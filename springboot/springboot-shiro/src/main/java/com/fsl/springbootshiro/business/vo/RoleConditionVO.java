package com.fsl.springbootshiro.business.vo;

import com.fsl.springbootshiro.business.entity.Role;
import com.fsl.springbootshiro.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class RoleConditionVO extends BaseConditionVO {
    private Role role;
}

