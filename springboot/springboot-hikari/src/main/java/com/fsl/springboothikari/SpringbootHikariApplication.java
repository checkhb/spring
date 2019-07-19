package com.fsl.springboothikari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fsl.springboothikari.mapper")
public class SpringbootHikariApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHikariApplication.class, args);
	}

}
