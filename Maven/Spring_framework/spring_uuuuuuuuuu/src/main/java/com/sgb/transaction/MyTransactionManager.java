package com.sgb.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * @author ***
 * @create 2021-12-28 19:44
 * 事务管理工具类  需求  完成得功能:开启事务  提交事务  回滚事务
 */
@Component
public class MyTransactionManager {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    //开启事务
    public TransactionStatus startTransaction(TransactionDefinition definition){
        TransactionStatus   status = transactionManager.getTransaction(definition);//这是事务状态
        return status;
    }
    //提交事务
    public void commit(TransactionStatus status){
        transactionManager.commit(status);
    }
    //回滚事务
    public void rollback(TransactionStatus status){
        transactionManager.rollback(status);
    }
}
