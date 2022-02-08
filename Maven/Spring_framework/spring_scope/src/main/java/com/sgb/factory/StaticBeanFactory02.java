package com.sgb.factory;

import com.sgb.pojo.Bean02;

/**
 * @author ***
 * @create 2021-12-24 13:29
 */
public class StaticBeanFactory02 {
    public static Bean02 getBean(){
        return new Bean02();
    }
}
