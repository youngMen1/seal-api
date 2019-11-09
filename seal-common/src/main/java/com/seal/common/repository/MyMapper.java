package com.seal.common.repository;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description 通用Mapper
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
