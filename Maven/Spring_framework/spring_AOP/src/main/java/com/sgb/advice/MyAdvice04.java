package com.sgb.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


/**
 * 编写spring-core.xml配置文件----(原因:配置 目标对象 与 通知 之间得关系)
 * @author ***
 * @create 2021-12-27 20:45
 * 通知类
 */
@Component
public class MyAdvice04 {

    /**
     * 前置通知
     */
    public void around2Before(ProceedingJoinPoint pjp){
        System.out.println("MyAdvice03 before");
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    /**
     * 正常后置通知
     * @param pjp
     */
    public void around2AfterReturning(ProceedingJoinPoint pjp){
        try {
            pjp.proceed();
            //1
            System.out.println("MyAdvice03 afterReturning");
        } catch (Throwable e) {
            e.printStackTrace();
            //2
        }
        //3

    }


    /**
     * 异常后置通知
     * @param pjp
     */
    public void around2AfterThrowing(ProceedingJoinPoint pjp){
        try {
            pjp.proceed();
            //1
        } catch (Throwable e) {
            e.printStackTrace();
            //2
            System.out.println("MyAdvice03 afterThrowing");
            throw new RuntimeException(e);
        }
        //3

    }


    /**
     * 后置通知
     * @param pjp
     */
    public void around2After(ProceedingJoinPoint pjp){
        try {
            pjp.proceed();
            //1
        } catch (Throwable e) {
            e.printStackTrace();
            //2
            throw new RuntimeException(e);
        } finally {
            //3
            System.out.println("MyAdvice03 after");
        }

    }

}