package com.sgb.mapper;

import com.sgb.pojo.Customer;

/**
 * @author ***
 * @create 2021-12-22 10:10
 */
public interface CustomerMapper {
    /**
     * 根据customerId查询用户信息和订单信息
     * @param customerId
     * @return
     * @throws Exception
     */
    Customer selectCustomerAndCustomerByOrderId(Integer customerId)throws Exception;
    /**
     * ①③第二次单表查询   多表查询(第二步)
     */
    Customer selectCustomerByCustomerId( Integer customerId)throws Exception;
    /**
     * ②①第一次单表查询
     * @param customerName
     * @return
     * @throws Exception
     */
    Customer selectCustomerByCustomerName(String customerName) throws Exception;
    Customer customerMap(String customerName) throws Exception;
}
