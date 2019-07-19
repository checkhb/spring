package com.fsl.springbootdynamicline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class SpringbootDynamicLineApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(SpringbootDynamicLineApplication.class, args);
    }

    @RequestMapping("/dynamicLine")
    public String dynamicLine(){
        return "dynamicLine";
    }
	
	/**
     * 网上推荐的快捷使用方法，无效
     * @return
     */
    @RequestMapping("/dynamicLine_b")
    public String dynamicLineB(){
        return "dynamicLine_b";
    }
}
