package com.sgb.mapper;

import com.sgb.pojo.User;

/**
 * @author ***
 * @create 2021-12-23 11:08
 */
public interface UserMapper {
    User selectOrderAndCustomerByOrderId(Integer userId)throws Exception;
}
