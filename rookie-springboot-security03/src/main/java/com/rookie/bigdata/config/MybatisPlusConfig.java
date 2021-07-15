package com.rookie.bigdata.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Classname MybatisPlusConfig
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/13 11:43
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.rookie.bigdata.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
