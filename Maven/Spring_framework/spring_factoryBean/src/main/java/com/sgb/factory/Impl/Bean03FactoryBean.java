package com.sgb.factory.Impl;

import com.sgb.pojo.Bean03;
import org.springframework.beans.factory.FactoryBean;


/**
 * @author ***
 * @create 2021-12-24 19:46
 */
public class Bean03FactoryBean implements FactoryBean<Bean03> {

    @Override
    public Bean03 getObject() throws Exception {
        return new Bean03();
    }

    @Override
    public Class<?> getObjectType() {
        return Bean03.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
