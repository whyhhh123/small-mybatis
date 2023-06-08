package com.small.mybatis.mapping;

import com.small.mybatis.session.Configuration;

import java.util.Map;

/**
 * @author why
 * @description 映射语句类
 * @since 2023/05/31/16:25
 */
public class MappedStatement {

    private Configuration configuration;

    /**
     * sql语句唯一id 类名+sql语句名
     */
    private String id;
    /**
     * sql类型
     */
    private SqlCommandType sqlCommandType;

    private BoundSql boundSql;

    public MappedStatement() {
    }

    /**
     * 建造者模式
     */
    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration,String id,SqlCommandType sqlCommandType,BoundSql boundSql){
            mappedStatement.configuration=configuration;
            mappedStatement.id=id;
            mappedStatement.sqlCommandType=sqlCommandType;
            mappedStatement.boundSql=boundSql;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getId() {
        return id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public BoundSql getBoundSql() {
        return boundSql;
    }

}
