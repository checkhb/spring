package com.fsl.springbootshiro.framework.config;

import com.fsl.springbootshiro.framework.tag.CustomTagDirective;
import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * freemarker配置类
 * @author yudd
 * @date 2019年5月16日14:20:27
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    protected freemarker.template.Configuration configuration;
    @Autowired
    protected CustomTagDirective customTagDirective;

    /**
     * 添加自定义标签
     */
    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("zhydTag", customTagDirective);
        //shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
