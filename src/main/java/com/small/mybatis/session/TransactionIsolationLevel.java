package com.small.mybatis.session;

import com.mysql.jdbc.ConnectionPropertiesTransform;

import java.sql.Connection;

/**
 * @author why
 * @since 2023/06/07/23:00
 */
public enum TransactionIsolationLevel {
    //包括JDBC支持的5个级别
    NONE(Connection.TRANSACTION_NONE),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
    private final int level;
    TransactionIsolationLevel(int level) {
        this.level =level;
    }
    public int getLevel(){
        return level;
    }
}
