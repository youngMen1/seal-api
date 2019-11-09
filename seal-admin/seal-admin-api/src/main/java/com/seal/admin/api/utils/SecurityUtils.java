package com.seal.admin.api.utils;

import com.seal.admin.api.config.SctUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description
 **/
@UtilityClass
public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public SctUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public String getUsername() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof SctUser)) {
            return (String) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public SctUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof SctUser) {
            return (SctUser) principal;
        }
        return null;
    }
}
