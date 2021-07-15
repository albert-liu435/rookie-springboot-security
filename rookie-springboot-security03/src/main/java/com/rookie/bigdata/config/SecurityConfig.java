package com.rookie.bigdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname SecurityConfig
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 14:50
 * @Version 1.0
 */
@Configuration
public class SecurityConfig {

    /***
     * 密码加密方式
     * @return
     */
    @Bean
    public PasswordEncoder buildPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
