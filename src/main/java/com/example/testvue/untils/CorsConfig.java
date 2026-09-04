package com.example.testvue.untils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // 允许的域名（开发环境用 *，生产环境指定具体域名）
//        config.addAllowedOriginPattern("*");  // Spring Boot 2.4+ 使用此方法
         config.addAllowedOrigin("http://localhost:5173"); // 指定具体前端地址

        // 允许的请求方式
        config.addAllowedMethod("*");

        // 允许的请求头
        config.addAllowedHeader("*");

        // 允许携带凭证（Cookie/Token）
        config.setAllowCredentials(true);

        // 预检请求缓存时间（单位：秒）
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}