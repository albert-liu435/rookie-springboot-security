package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname SecurityApplication
 * @Description 在浏览器中输入 http://localhost:8087/sys/getUser,会跳转到相应的登录页面
 * 输入账号： admin  密码：123456
 * @Author rookie
 * @Date 2021/7/15 11:47
 * @Version 1.0
 */
@SpringBootApplication
public class SecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}