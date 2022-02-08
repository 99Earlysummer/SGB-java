package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ***
 * @create 2021-12-22 9:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer orderId;
    //订单编号
    private String orderState;
    //订单状态
    private Customer customer;
    //用户信息

}