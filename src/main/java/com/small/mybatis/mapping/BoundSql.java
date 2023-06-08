package com.small.mybatis.mapping;

import java.util.Map;

/**
 * @author why
 * @since 2023/06/08/14:42
 */
public class BoundSql {
    private String sql;
    private Map<Integer,String> parameterMapping;
    private String parameterType;
    private String resultType;

    public BoundSql(String sql, Map<Integer, String> parameterMapping, String parameterType, String resultType) {
        this.sql = sql;
        this.parameterMapping = parameterMapping;
        this.parameterType = parameterType;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public Map<Integer, String> getParameterMapping() {
        return parameterMapping;
    }

    public String getParameterType() {
        return parameterType;
    }

    public String getResultType() {
        return resultType;
    }
}
