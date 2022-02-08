package com.sgb.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * 编写spring-core.xml配置文件----(原因:配置 目标对象 与 通知 之间得关系)
 * @author ***
 * @create 2021-12-27 20:45
 * 通知类
 */
@Component  //加入spring容器
@Aspect  //配置切面
public class MyAdvice03 {
    /*after-throwing、around可以获取切入点的异常*/


        @AfterThrowing(value = "execution(* *..*Service.addUser())",throwing = "e")
        public void afterThrowing(Exception e){
            System.out.println("错误日志记录"+e);
        }

        @Around("execution(* *..*Service.addUser())")
        public void around(ProceedingJoinPoint pjp){
            try {
                Object proceed = pjp.proceed();

            } catch (Throwable e) {
                System.out.println("错误日志记录");
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
}
