package com.sgb.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 编写spring-core.xml配置文件----(原因:配置 目标对象 与 通知 之间得关系)
 * @author ***
 * @create 2021-12-27 20:45
 * 通知类
 */
@Component  //加入spring容器
@Aspect  //配置切面
public class MyAdvice01 {

        @Before("execution(* *..*Service.addUser())")
        public void before(){
            System.out.println("权限校验");
        }

        @AfterReturning("execution(* *..*Service.addUser())")
        public void afterReturning(){
            System.out.println("日志记录");
        }

        @Around("execution(* *..*Service.addUser())")
        public void around(ProceedingJoinPoint pjp){
            System.out.println("日志记录");
            try {
                pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        @After("execution(* *..*Service.addUser())")
        public void after(){
            System.out.println("日志记录");
        }

        @AfterThrowing("execution(* *..*Service.addUser())")
        public void afterThrowing(){
            System.out.println("日志记录");
        }

}
