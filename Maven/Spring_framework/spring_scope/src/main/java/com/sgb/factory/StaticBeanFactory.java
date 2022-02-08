package com.sgb.factory;

import com.sgb.pojo.Bean01;

/**
 * @author ***
 * @create 2021-12-24 13:29
 */
public class StaticBeanFactory {
    //将bean加入spring
    public static Bean01 getBean(){
        return new Bean01();
    }
}
