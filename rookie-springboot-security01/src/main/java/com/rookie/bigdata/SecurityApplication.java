package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname SecurityApplication
 * @Description 采用postman的方式进行调用     http://localhost:8080/hello
 * 在认证 方式 选择 Basic Auth 填写用户名和 密码
 * @Author rookie
 * @Date 2021/7/15 11:19
 * @Version 1.0
 */
@SpringBootApplication
public class SecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
