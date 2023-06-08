package com.small.mybatis.transaction;

import com.small.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author why
 * @since 2023/06/07/22:54
 */
public interface TransactionFactory {
    /**
     * 根据Connection 创建 Transaction
     * @param connection Existing database connection
     * @return Transaction
     */
    Transaction newTransaction(Connection connection);


    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level,boolean autoCommit);
}
