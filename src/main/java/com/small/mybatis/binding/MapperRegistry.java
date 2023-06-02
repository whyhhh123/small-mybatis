package com.small.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author why
 * @since 2023/05/29/15:50
 */
public class MapperRegistry {
    private final static Logger logger = LoggerFactory.getLogger(MapperRegistry.class);

    private final Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public boolean hasMapper(Class<?> type) {
        return knownMappers.containsKey(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {

        if (knownMappers.containsKey(type)) {
            MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
            return mapperProxyFactory.newInstance(sqlSession);
        } else {
            throw new NullPointerException();
        }

    }

    public void addMapper(Class<?> type) {
        if (!hasMapper(type)) {
            MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(type);
            knownMappers.put(type, mapperProxyFactory);
        } else {
            logger.error("包含相同mapper");
            throw new RuntimeException();

        }
    }

    public void addMappers(String packagePath) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packagePath);
        for (Class<?> mapperClass : mapperSet) {
            if (mapperClass.isInterface()) {
                addMapper(mapperClass);
            }
        }

    }
}
