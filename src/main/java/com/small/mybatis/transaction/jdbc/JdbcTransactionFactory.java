package com.small.mybatis.transaction.jdbc;

import com.small.mybatis.session.TransactionIsolationLevel;
import com.small.mybatis.transaction.Transaction;
import com.small.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author why
 * @since 2023/06/07/23:15
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource,level,autoCommit);
    }
}
