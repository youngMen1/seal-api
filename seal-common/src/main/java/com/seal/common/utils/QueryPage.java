package com.seal.common.utils;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description
 **/
@Data
@ToString
public class QueryPage implements Serializable {

    /**
     * 当前页
     */
    private int pageCode;

    /**
     * 每页显示的记录数
     */
    private int pageSize;
}
