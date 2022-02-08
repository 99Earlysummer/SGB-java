package com.sgb.advice;/*
package com.sgb.advice;

import com.sgb.transaction.MyTransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

*/
/**
 * @author ***
 * @create 2021-12-28 20:36
 * 事务通知类(附属功能-代理类)
 * 只负责事务管理
 *//*

@Component
public class TxAdvice {
    */
/**
     * 事务通知
     *//*

    @Autowired
   private MyTransactionManager myTransactionManager;//


    @Autowired
    @Qualifier("definition1")
    private TransactionDefinition definition1;
    */
/**
     * dml事务通
     * @param pjp
     *//*

    public void dmlAround(ProceedingJoinPoint pjp){
        TransactionStatus status=null;//状态
        try {
            //开启事务
            myTransactionManager.startTransaction(definition1);
            //执行切入点即原方法
            pjp.proceed();
            //提交事务
            myTransactionManager.commit(status);
        } catch (Throwable e) {
            e.printStackTrace();
            //如果异常 回滚事务
            myTransactionManager.rollback(status);
        }
    }

    @Autowired
    @Qualifier("definition2")
    private TransactionDefinition definition2;
    */
/**
     *sql事务
     *//*

    public void dqlAround(ProceedingJoinPoint pjp){
        TransactionStatus status = null;
        //开启事务
        try {
            status = myTransactionManager.startTransaction(definition2);
            pjp.proceed();
            myTransactionManager.commit(status);
        } catch (Throwable e) {
            e.printStackTrace();
            myTransactionManager.rollback(status);

        }
    }


}
*/
