package com.sgb.pojo;


import java.util.List;

/**
 * @author ***
 * @create 2021-12-22 9:24
 */
public class Customer {

    private Integer customerId;
    //用户编号
    private String customerName;
    //用户姓名
    private String address;
    //收货地址
    private List<Order> orderList;
    //订单列表

}
