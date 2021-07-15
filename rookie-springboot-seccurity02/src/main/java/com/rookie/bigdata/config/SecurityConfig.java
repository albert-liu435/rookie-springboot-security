package com.rookie.bigdata.config;

import com.rookie.bigdata.provider.CustomerAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname SecurityConfig
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 11:50
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // 配置自定义的校验器
        auth.authenticationProvider(customeProvider());
    }


    /***
     * 密码加密方式
     * @return
     */
    @Bean
    public PasswordEncoder buildPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider customeProvider() {
        return new CustomerAuthenticationProvider();
    }


}
