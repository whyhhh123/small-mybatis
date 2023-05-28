package com.small.mybatis;

import com.small.mybatis.binding.MapperProxyFactory;
import com.small.mybatis.dao.UserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author why
 * @since 2023/05/28/18:10
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(UserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.small.mybatis.dao.UserDao.queryUserName", "执行queryUserName");
        UserDao userDao = (UserDao) mapperProxyFactory.newInstance(sqlSession);
        String result = userDao.queryUserName("12");
        logger.info(result);

    }
    @Test
    public void test_proxy(){

        UserDao userDao = (UserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{UserDao.class},
                ((proxy, method, args) ->
                  "你被代理了"));
        String result = userDao.queryUserName("10");
        logger.info(result);
    }
}
