package com.seal.common.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description
 **/
@Getter
@AllArgsConstructor
public enum CommonEnums {

    LOGIN_ERROR(500, "用户名或密码错误"),
    PARAM_ERROR(401, "参数错误"),
    USER_ERROR(500, "获取用户信息失败"),
    LOGOUT_ERROR(500, "退出失败"),
    SYSTEM_ERROR(500, "系统内部错误");

    private final int code;
    private final String msg;
}
