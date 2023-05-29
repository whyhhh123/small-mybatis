package com.small.mybatis.session.impl;

import com.small.mybatis.binding.MapperRegistry;
import com.small.mybatis.session.SqlSession;

/**
 * @author why
 * @since 2023/05/29/16:01
 */
public class DefaultSqlSession implements SqlSession {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public String selectOne(String uid) {
        return "哈哈哈，你被代理了";
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T)"哈哈哈，你被代理了";
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return (T)mapperRegistry.getMapper(type,this);
    }
}
