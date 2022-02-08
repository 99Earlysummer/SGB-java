package com.sgb.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


/**
 * 编写spring-core.xml配置文件----(原因:配置 目标对象 与 通知 之间得关系)
 * @author ***
 * @create 2021-12-27 20:45
 * 通知类
 */
@Component  //加入spring容器
public class MyAdvice03 {
    /**
     * 前置通知
     */
        public void before(){
            System.out.println("MyAdvice02 before");
        }

    /**
     * 正常后置通知
     */
    public void afterReturning(){
            System.out.println("MyAdvice02 afterReturning");
        }

    /**
     * 异常后置通知
     */
    public void afterThrowing(){
            System.out.println("MyAdvice02 afterThrowing");
        }

    /**
     *后置通知
     */
    public void after(){
            System.out.println("MyAdvice02 after");
        }

    /**
     * 环绕通知   (正在执行得连接点)
     * @param pjp
     */
    public void around(ProceedingJoinPoint pjp){
            System.out.println("MyAdvice02 before");


        //执行切入点
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("MyAdvice02 after");
    }
}
