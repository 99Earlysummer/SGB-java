package com.sgb.processor;

import com.sgb.datasource.MyDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ***
 * @create 2021-12-25 9:46
 */
public class MyDataSourcePostProcessor implements BeanPostProcessor {
    //这里是在初始化之前的前置处理

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyDataSource){//判断存在情况
            System.out.println("③①MyDataSource初始化之前");
            MyDataSource dataSource= (MyDataSource) bean;
            System.out.println("连接池 : " + dataSource.getInitPoolSize());//5
            dataSource.setInitPoolSize(10);
        }
        return bean;
    }
    //这里是在初始化之后的前置处后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyDataSource) {
            System.out.println("③③MyDataSource初始化之后");
            MyDataSource dataSource = (MyDataSource) bean;
            System.out.println("连接池 : " + dataSource.getInitPoolSize());//10
        }
        return bean;
    }
}
