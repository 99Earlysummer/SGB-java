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
public class MyAdvice02 {
    /*after-returning、around可以获取切入点返回值*/


        @AfterReturning(value = "execution(* *..*Service.addUser())",returning="as")
        public void afterReturning(int as){
            System.out.println("日志记录"+as);
        }

        @Around("execution(* *..*Service.addUser())")
        public Object around(ProceedingJoinPoint pjp){
            System.out.println("日志记录");
            try {
                Object proceed = pjp.proceed();
                return proceed;
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        }
}
