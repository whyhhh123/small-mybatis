package com.small.mybatis.session.impl;

import com.small.mybatis.mapping.MappedStatement;
import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.SqlSession;

/**
 * @author why
 * @since 2023/05/29/16:01
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String selectOne(String uid) {
        return "哈哈哈，你被代理了";
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return (T) configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
