package com.atguigu.meinian.service;

import com.atguigu.meinian.entity.Result;

import java.util.Map;

public interface OrderService {
/*2*/
    Result submitOrder(Map map) throws Exception;

    Map findById(Integer id);
}
