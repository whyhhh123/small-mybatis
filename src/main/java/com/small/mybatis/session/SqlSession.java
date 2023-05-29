package com.small.mybatis.session;

/**
 * @author why
 * @since 2023/05/29/15:50
 */
public interface SqlSession {

     <T> T selectOne(String uid);

    <T> T selectOne(String statement, Object parameter);

    <T> T getMapper(Class<T> type);


}
