package com.fsl.springbootcacheredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fsl.springbootcacheredis.mapper")
public class SpringbootCacheRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheRedisApplication.class, args);
	}

}
