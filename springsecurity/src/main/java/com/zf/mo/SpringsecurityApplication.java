package com.zf.mo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springsecurity中文文档
 * https://www.springcloud.cc/spring-security-zhcn.html#true-
 */
@SpringBootApplication
@MapperScan("com.zf.mo.dao")
public class SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
    }

}
