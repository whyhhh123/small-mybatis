package com.small.mybatis.binding;

import com.small.mybatis.mapping.MappedStatement;
import com.small.mybatis.mapping.SqlCommandType;
import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * @author why
 * @since 2023/05/31/16:04
 */
public class MapperMethod {
    private SqlCommand sqlCommand;

    public MapperMethod(Class<?> mapperInterface, Configuration configuration, Method method) {
        this.sqlCommand = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (sqlCommand.getCommandType()) {
            case INSERT:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            case SELECT:
                result = sqlSession.selectOne(sqlCommand.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + sqlCommand.getName());
        }
        return result;
    }

    /**
     * sql 指令
     */
    public static class SqlCommand {
        private final SqlCommandType commandType;
        private final String name;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement mappedStatement = configuration.getMappedStatement(statementName);
            this.commandType = mappedStatement.getSqlCommandType();
            this.name = mappedStatement.getId();
        }

        public SqlCommandType getCommandType() {
            return commandType;
        }

        public String getName() {
            return name;
        }
    }
}
