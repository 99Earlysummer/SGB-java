package com.sgb.factory;

import com.sgb.pojo.Bean02;

/**
 * @author ***
 * @create 2021-12-24 13:49
 */
public class DynamicBeanFactory {
    //将bean加入到spring容器
    public Bean02 getBean(){
        return new Bean02();
    }

}
