package com.rookie.bigdata.config;

import com.rookie.bigdata.filter.JWTAuthenticationFilter;
import com.rookie.bigdata.filter.JWTAuthorizationFilter;
import com.rookie.bigdata.provider.CustomerAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
public class CustomerWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // 配置自定义的校验器
        auth.authenticationProvider(customeProvider());
    }


    /**
     * 配置拦截请求
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用csrf功能
        http.csrf()
                .disable()
                .authorizeRequests()
                //对于/sys/的请求进行放行
                .antMatchers("/sys/**")
                .permitAll()
                //其他的所有请求需要有admin权限
                .anyRequest()
                .hasAnyAuthority("管理员")
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                //token过滤器
                .addFilterAfter(new JWTAuthorizationFilter(), JWTAuthenticationFilter.class)
                //不需要使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)


        ;
//        http
//                // 禁用csrf
//                .csrf().disable()
//                .authorizeRequests()
//                //对/auth/**的请求进行放行
//                .antMatchers("/auth/**").permitAll()
//                //所有的 请求需要有ADMIN的角色
//                .anyRequest().hasAnyAuthority("ADMIN") // .authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                // 让校验 Token 的过滤器在身份认证过滤器之后
//                .addFilterAfter(new JWTAuthorizationFilter(), JWTAuthenticationFilter.class)
//                // 不需要 Session
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public AuthenticationProvider customeProvider() {
        return new CustomerAuthenticationProvider();
    }


}
