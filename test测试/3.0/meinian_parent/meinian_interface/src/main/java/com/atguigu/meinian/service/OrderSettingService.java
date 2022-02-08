package com.atguigu.meinian.service;

import com.atguigu.meinian.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {
    void add(List<String[]> lists);
    /**
     * 文件保存
     * @param
     */
    List<Map> getOrderSettingByMonth(String orderDate);


    /**
     * 设置预约信息
     * @param orderSetting
     */
    void updateNumberByOrderDate(OrderSetting orderSetting);
}
