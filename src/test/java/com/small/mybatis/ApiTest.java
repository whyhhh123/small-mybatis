package com.small.mybatis;

import com.small.mybatis.binding.MapperRegistry;
import com.small.mybatis.dao.UserDao;
import com.small.mybatis.session.SqlSession;
import com.small.mybatis.session.impl.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * @author why
 * @since 2023/05/28/18:10
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_proxy() {

        UserDao userDao = (UserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{UserDao.class},
                ((proxy, method, args) ->
                        "你被代理了"));
        String result = userDao.queryUserName("10");
        logger.info(result);
    }

    /**
     * 第一章测试
     */
   /* @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(UserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.small.mybatis.dao.UserDao.queryUserName", "执行queryUserName");
        UserDao userDao = (UserDao) mapperProxyFactory.newInstance(sqlSession);
        String result = userDao.queryUserName("12");
        logger.info(result);

    }*/

    /**
     * 第二章测试
     */
    @Test
    public void test_MapperRegistry() {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.small.mybatis.dao");
        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        String result = userDao.queryUserName("1");
        System.out.println(result);
    }
}
