package com.fsl.springbootshiro.persistence.beans;

import com.fsl.springbootshiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * @author yudd
 * 2019年5月16日08:57:56
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole extends AbstractDO {
    private String name;
    private String description;
    private Boolean available;

    @Transient
    private Integer selected;
}
