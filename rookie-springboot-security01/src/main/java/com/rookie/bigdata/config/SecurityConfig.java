package com.rookie.bigdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname SecurityConfig
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 11:19
 * @Version 1.0
 */
@Configuration//(proxyBeanMethods = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 配置请求需要携带 的 认证信息
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  配置用户名 / 密码
        auth.inMemoryAuthentication()
                .withUser("rookie").roles("ADMIN").password(buildPasswordEncoder().encode("rookie"))
                .and()
                .withUser("user").roles("USER").password(buildPasswordEncoder().encode("user"));
    }

    /**
     * 配置认证方式
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置任何请求都需要进行认证
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                //配置认证方式为httpBasic的认证方式
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }


    /**
     * 配置密码加密的方式
     *
     * @return
     * @Configuration(proxyBeanMethods = false)这种 情况下 ，在 configure(AuthenticationManagerBuilder auth)中使用buildPasswordEncoder(),每次都会生成新BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder buildPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder);
        return bCryptPasswordEncoder;
    }


}
