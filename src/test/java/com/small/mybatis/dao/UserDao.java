package com.small.mybatis.dao;

import com.small.mybatis.po.User;

/**
 * @author why
 * @since 2023/05/28/18:09
 */
public interface UserDao {
    User queryUserName(Long uid);
}
