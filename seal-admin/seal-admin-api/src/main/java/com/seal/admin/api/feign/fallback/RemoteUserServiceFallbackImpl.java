package com.seal.admin.api.feign.fallback;

import com.seal.admin.api.entity.SysUser;
import com.seal.admin.api.feign.RemoteUserService;
import com.seal.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description
 **/
@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {

    @Override
    public Result<SysUser> info(String username) {
        log.error("查询用户信息失败，username >> {}", username);
        return null;
    }
}
