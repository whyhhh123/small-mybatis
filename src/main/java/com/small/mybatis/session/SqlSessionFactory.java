package com.small.mybatis.session;

/**
 * @author why
 * @since 2023/05/29/15:59
 */
public interface SqlSessionFactory {

    SqlSession openSqlSession();
}
