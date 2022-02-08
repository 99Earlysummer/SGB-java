package com.sgb.mapper;

/**
 * @author ***
 * @create 2021-12-28 15:08
 */
public interface UserDao {
    void inMoney(String inMoney,Double money)throws Exception;

    void onMoney(String onMoney,Double money)throws Exception;
}
