package com.fsl.springbootcacheredis.config;

import com.fsl.springbootcacheredis.util.SnowFlakeWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author 2019年6月27日09:27:12
 * 雪花算法配置
 */
@Configuration
public class SnowFlakeConfig {

    @Bean
    @Scope("singleton")
    public SnowFlakeWorker getIdWorker() {
        return new SnowFlakeWorker(0, 0);
    }
}
