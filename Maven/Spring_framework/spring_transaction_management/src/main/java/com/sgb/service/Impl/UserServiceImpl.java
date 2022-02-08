package com.sgb.service.Impl;

import com.sgb.mapper.UserDao;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author ***
 * @create 2021-12-28 15:07
 * 基础版事务管理代码过多  因此要做到单一职责原则  一个类只完成
 * 主要功能:增删查改
 * 附属功能:事务管理
 * 可以考虑使用aop注解开发
 * 第二阶段:将事务管理抽出来独立成类
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
/*    @Autowired
    private DataSourceTransactionManager transactionManager;//
    @Autowired
    private MyTransactionManager myTransactionManager;*/

    //先看@Autowired注解required属性如果没有匹配到或者bean有多个时就让qualifier指定bean注入
/*    @Autowired  //根据类型注入 如果有重复类型就不能确保唯一性 因此得就按照变量名注入
    @Qualifier("definition1")//按照属性名注入
    private TransactionDefinition definition;//事务状态*/
    @Override
    public void transfer(String outName, String inName, Double money) throws Exception {
       /* TransactionStatus status=null;//后期操作有需要有事务状态校验因此需要这个工具变量*/
/*
            //开启事务                                     策略
            *//* status = transactionManager.getTransaction(definition);*//*
             status = myTransactionManager.startTransaction();*/

            //出账
            userDao.onMoney(outName,money);
            //制造异常 检测程序
           //System.out.println(1/0);
            //入账
            userDao.inMoney(inName,money);
            //没有异常  提交事务
           /* transactionManager.commit(status);*/
            /*myTransactionManager.commit(status);*/

            //出现异常  回滚事务
            /*transactionManager.rollback(status);*/
          /*  myTransactionManager.rollback(status);*/





    }
}
