package com.sgb.mapper;

import com.sgb.pojo.Order;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-22 9:20
 */
public interface OrderMapper {
    /**
     * 关联查询
     * @param orderId
     * @return
     * @throws Exception
     */
    Order selectOrderAndCustomerByOrderId(Integer orderId)throws Exception;

    /**
     * 将上面的语句 拆分多步骤查询多表(第一步)
     * @param orderId
     * @return
     * @throws Exception
     */
    Order selectOrderByOrderId(Integer orderId)throws Exception;

    /**
     * ②③ 第二次单表查询
     * @return
     * @throws Exception
     */
    List<Order> selectOrderListByCustomerId(Integer customerId)throws Exception;
}
