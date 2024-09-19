package com.demo.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan("com.demo.crm.biz.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    // 跨域
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
        //允许跨域
        config.addAllowedOrigin("*");
        //允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        //允许cookie
        // config.setAllowCredentials(true);
        //允许的method
        config.addAllowedMethod("*");
        //免检时间,单位是秒
        //config.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
