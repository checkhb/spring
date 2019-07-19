package com.fsl.springbootspringsession.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author: sj2
 * HttpSession 配置
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig{

}
