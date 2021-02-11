package com.zf.mo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//https://blog.csdn.net/qq_43371556/article/details/100898816
@RestController
@SpringBootApplication
@MapperScan("com.zf.mo.mapper")
public class SpringSecurityDemoApplication {
    @RequestMapping("/run")
    public String demo(){
        return "hello spring security";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

}
