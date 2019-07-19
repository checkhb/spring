package com.fsl.springbootshiro.persistence.beans;

import com.fsl.springbootshiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yudd
 * 2019年5月16日08:59:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRole extends AbstractDO {
    private Long userId;
    private Long roleId;
}
