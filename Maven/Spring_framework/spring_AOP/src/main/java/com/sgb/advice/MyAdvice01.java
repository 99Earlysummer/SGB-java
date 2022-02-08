package com.sgb.advice;

import org.springframework.stereotype.Component;


/**
 * 编写spring-core.xml配置文件----(原因:配置 目标对象 与 通知 之间得关系)
 * @author ***
 * @create 2021-12-27 20:45
 * 通知类
 */
@Component  //加入spring容器
public class MyAdvice01 {
    /**
     * 通知
     */
        public void checkPermission(){
            System.out.println("权限校验");
        }
        public void printLog(){
            System.out.println("日志记录");
        }

}
