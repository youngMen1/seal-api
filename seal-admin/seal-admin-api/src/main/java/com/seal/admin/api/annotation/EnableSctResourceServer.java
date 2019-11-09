package com.seal.admin.api.annotation;

import com.seal.admin.api.config.ResourceServerConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description 扩展资源服务注解
 * @Inherited 该注解阐述被标记的类型是被继承的
 * @Retention(RetentionPolicy.RUNTIME) 生命周期最大的注解类型，不仅被保存在Class中，在JVM中加载Class之后仍让存在
 **/
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Import({ResourceServerConfig.class})
public @interface EnableSctResourceServer {
}
