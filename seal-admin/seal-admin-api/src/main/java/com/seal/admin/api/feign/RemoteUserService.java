package com.seal.admin.api.feign;

import com.seal.admin.api.entity.SysUser;
import com.seal.admin.api.feign.fallback.RemoteUserServiceFallbackImpl;
import com.seal.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description 用户远程调用接口
 **/
@FeignClient(value = "seal-admin-biz", fallback = RemoteUserServiceFallbackImpl.class)
public interface RemoteUserService {

    /**
     * 根据用户名查找用户信息
     *
     * @return
     */
    @GetMapping("/user/info/{username}")
    Result<SysUser> info(@PathVariable("username") String username);
}
