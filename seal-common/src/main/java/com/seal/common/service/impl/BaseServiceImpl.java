package com.seal.common.service.impl;

import com.seal.common.service.BaseService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description 封装通用Service接口实现类
 **/
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    @Getter
    private Mapper<T> mapper;

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public void save(T entity) {
        mapper.insert(entity);
    }

    @Override
    public void delete(Object key) {
        mapper.deleteByPrimaryKey(key);
    }

    @Override
    public void batchDelete(List<Long> ids, String property, Class<T> clazz) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, ids);
        this.mapper.deleteByExample(example);
    }

    @Override
    public void updateAll(T entity) {
        mapper.updateByPrimaryKey(entity);
    }

    /**
     * updateByPrimaryKeySelective()和updateByPrimaryKey()区别是前者会进行字段校验再更新，如果字段值为null就不更新
     *
     * @param entity
     */
    @Override
    public void updateNotNull(T entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
}
