package com.fsl.springbootshiro.business.enums;

/**
 * @author yudd
 * @date 2019年5月16日14:02:28
 */
public enum ResourceTypeEnum {
    menu("菜单"), button("按钮");

    private final String info;

    private ResourceTypeEnum(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
