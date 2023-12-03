package com.lhc.config;

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
        //设置访问源
        //config.addAllowedOrigin("*");
        config.addAllowedOriginPattern("*");
        //设置访问源请求头
        config.addAllowedHeader("*");
        //设置访问源请求方法
        config.addAllowedMethod("*");
        //是否发送cookie
        config.setAllowCredentials(true);
        //设置请求跨域最大有效时间
        long maxAge = 24 * 60 * 60;
        config.setMaxAge(maxAge);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
