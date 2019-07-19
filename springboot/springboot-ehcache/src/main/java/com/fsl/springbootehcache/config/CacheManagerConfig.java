package com.fsl.springbootehcache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheManagerConfig {

    @Value("${spring.cache.ehcache.config}")
    private String ehCacheCongifPath;


    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        System.out.println(ehCacheCongifPath);
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource(ehCacheCongifPath));
        cacheManagerFactoryBean.setShared(true);
        //如果 Factory 自己手动实列化，需要 执行afterPropertiesSet()方法，因为这是方法是 初始化 类使用的
        //如果Factory 由Spring 容器 创建 ，容器初始化完成后 spring 会去执行这个方法。
        //cacheManagerFactoryBean.afterPropertiesSet();
        // 初始化 读取配置文件,
        return cacheManagerFactoryBean;
    }

    @Bean
    public CacheManager compositeCacheManager(@Autowired EhCacheManagerFactoryBean factoryBean) {
        //RedisCacheManager redisCacheManager = getRedisCacheManager(redisTemplate);
        //GuavaCacheManager guavaCacheManager = getGuavaCacheManager();
        EhCacheCacheManager ehCacheCacheManager = ehCacheCacheManager(factoryBean);
        CompositeCacheManager cacheManager = new CompositeCacheManager(ehCacheCacheManager);
        cacheManager.setFallbackToNoOpCache(true);
        cacheManager.afterPropertiesSet();
        return cacheManager;
    }


    private EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean factoryBean) {
        //由于自己实列化EhCacheManager 需要执行 手动初始化 方法。
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(factoryBean.getObject());
        //初始化
        ehCacheCacheManager.initializeCaches();
        return ehCacheCacheManager;
    }

}
