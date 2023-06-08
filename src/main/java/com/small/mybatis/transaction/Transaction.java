package com.small.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author why
 * @since 2023/06/07/22:55
 */
public interface Transaction {
    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
