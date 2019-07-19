package com.fsl.springbootshiro.persistence.beans;

import com.fsl.springbootshiro.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yudd
 * 2019年5月16日08:57:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends AbstractDO {
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private String qq;
    private Date birthday;
    private Integer gender;
    private String avatar;
    private String userType;
    private String regIp;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Integer loginCount;
    private String remark;
    private Integer status;
}
