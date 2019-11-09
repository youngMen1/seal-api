package com.seal.common.service;

import java.util.List;


/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description 封装通用Service接口
 **/
public interface BaseService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    void save(T entity);

    void delete(Object key);

    void batchDelete(List<Long> ids, String property, Class<T> clazz);

    void updateAll(T entity);

    void updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
