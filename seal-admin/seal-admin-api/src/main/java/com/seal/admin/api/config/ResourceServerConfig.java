package com.seal.admin.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description
 **/
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.info("加载了 >> ResourceServerConfig...");
        http
                //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
                .headers()
                .frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/upload/**",
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/v2/api-docs/**")
                .permitAll()

                .antMatchers("/actuator/**", "/user/info/*", "/storage/local/upload")
                .permitAll()

                .anyRequest()
                .authenticated()

                .and()
                .csrf().disable();
    }
}
