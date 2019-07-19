package com.fsl.springbootshiro.persistence.beans;

import com.fsl.springbootshiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yudd
 * 2019年5月16日08:58:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleResources extends AbstractDO {
    private Long roleId;
    private Long resourcesId;
}
