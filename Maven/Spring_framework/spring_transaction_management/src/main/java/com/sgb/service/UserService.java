package com.sgb.service;

/**
 * @author ***
 * @create 2021-12-28 15:07
 */
public interface UserService {
        /**
         *
         * @param outName 转出人
         * @param inName 转入人
         * @param money 金额
         * @throws Exception
         */
        void transfer(String outName,String inName,Double money) throws Exception;
}
