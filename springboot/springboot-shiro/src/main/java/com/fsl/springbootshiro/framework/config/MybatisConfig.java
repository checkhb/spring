package com.fsl.springbootshiro.framework.config;

import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * @author yudd
 * @date 2019年5月16日14:20:42
 */
@Component
@MapperScan("com.fsl.springbootshiro.persistence.mapper")
public class MybatisConfig {
}
