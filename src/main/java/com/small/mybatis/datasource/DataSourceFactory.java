package com.small.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author why
 * @since 2023/06/07/23:59
 */
public interface DataSourceFactory {
    void setProperties(Properties properties);

    DataSource getDataSource();

}
