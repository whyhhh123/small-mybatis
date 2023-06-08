package com.small.mybatis.builder;

import com.small.mybatis.session.Configuration;
import com.small.mybatis.type.TypeAliasRegistry;

/**
 * @author why
 * @since 2023/05/31/16:29
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;
    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry=this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
