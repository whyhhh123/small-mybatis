package com.small.mybatis.session.impl;

import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.SqlSession;
import com.small.mybatis.session.SqlSessionFactory;

/**
 * @author why
 * @since 2023/05/29/16:01
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSqlSession() {
        return new DefaultSqlSession(configuration);
    }

}
