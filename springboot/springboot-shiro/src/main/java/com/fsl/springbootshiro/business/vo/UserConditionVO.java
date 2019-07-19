package com.fsl.springbootshiro.business.vo;


import com.fsl.springbootshiro.business.entity.User;
import com.fsl.springbootshiro.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yudd
 * @date 2019年5月16日14:11:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserConditionVO extends BaseConditionVO {
    private User user;
}
