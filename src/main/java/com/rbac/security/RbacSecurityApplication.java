package com.rbac.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.rbac.security.mapper")
public class RbacSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacSecurityApplication.class, args);
    }

}
