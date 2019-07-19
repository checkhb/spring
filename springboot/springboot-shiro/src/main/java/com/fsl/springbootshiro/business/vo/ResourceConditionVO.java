package com.fsl.springbootshiro.business.vo;

import com.fsl.springbootshiro.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceConditionVO extends BaseConditionVO {
    private String type;
}

