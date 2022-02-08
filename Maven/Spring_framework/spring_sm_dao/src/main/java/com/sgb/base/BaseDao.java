package com.sgb.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ***
 * @create 2021-12-30 0:13
 */
public class BaseDao extends SqlSessionDaoSupport {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
