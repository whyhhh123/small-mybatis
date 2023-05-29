package com.small.mybatis.session.impl;

import com.small.mybatis.binding.MapperRegistry;
import com.small.mybatis.session.SqlSession;
import com.small.mybatis.session.SqlSessionFactory;

/**
 * @author why
 * @since 2023/05/29/16:01
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSqlSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}
