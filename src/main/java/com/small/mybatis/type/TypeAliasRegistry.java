package com.small.mybatis.type;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author why
 * @since 2023/06/07/23:44
 */
public class TypeAliasRegistry {
    private final Map<String,Class<?>> TYPE_ALIASES=new HashMap<>();

    public TypeAliasRegistry(){
        //构造函数里注册系统内置的类型别名
        registryAlias("string",String.class);

        //基本包装类型
        registryAlias("byte",Byte.class);
        registryAlias("short",Short.class);
        registryAlias("int",Integer.class);
        registryAlias("integer",Integer.class);
        registryAlias("float",Float.class);
        registryAlias("double",Double.class);
        registryAlias("long",Long.class);
        registryAlias("boolean",Boolean.class);


    }
    public void registryAlias(String alias,Class<?> clazz){
        String key = alias.toLowerCase(Locale.ENGLISH);
        TYPE_ALIASES.put(key,clazz);
    }
    public <T> Class<T> resolveAlias(String string){
        String key = string.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIASES.get(key);
    }
}
