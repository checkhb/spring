package com.fsl.springbootsingledruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fsl.springbootsingledruid.mapper")
public class SpringbootSingleDruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSingleDruidApplication.class, args);
	}

}
