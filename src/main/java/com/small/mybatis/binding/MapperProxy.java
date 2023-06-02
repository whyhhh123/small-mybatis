package com.small.mybatis.binding;

import com.small.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author why
 * @since 2023/05/28/17:35
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;
    private final SqlSession sqlSession;
    private final Class<T> mapperInterFace;
    private final Map<Method, MapperMethod> methodCache;


    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterFace, Map<Method, MapperMethod> methodCache) {
        this.sqlSession = sqlSession;
        this.mapperInterFace = mapperInterFace;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {//如果是Object类的一些方法，则执行他们的逻辑
            return method.invoke(this, args);
        } else {
            final MapperMethod mapperMethod = cacheMapperMethod(method);
            return mapperMethod.execute(sqlSession, args);
        }
    }

    /**
     * 去缓存中找MapperMethod
     */
    private MapperMethod cacheMapperMethod(Method method) {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            //找不到采取new
            mapperMethod = new MapperMethod(mapperInterFace, sqlSession.getConfiguration(), method);
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}
