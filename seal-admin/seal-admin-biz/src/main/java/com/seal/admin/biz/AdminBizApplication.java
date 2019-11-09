package com.seal.admin.biz;

import com.seal.admin.api.annotation.EnableSctResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description 系统API业务接口 admin
 **/
@EnableSctResourceServer
@MapperScan("com.seal.admin.biz.mapper")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AdminBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminBizApplication.class, args);
    }
}
