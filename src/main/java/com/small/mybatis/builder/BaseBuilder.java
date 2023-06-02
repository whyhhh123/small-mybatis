package com.small.mybatis.builder;

import com.small.mybatis.session.Configuration;

/**
 * @author why
 * @since 2023/05/31/16:29
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
