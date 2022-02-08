package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.mapper.OrderSettingMapper;
import com.atguigu.meinian.pojo.OrderSetting;
import com.atguigu.meinian.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingMapper orderSettingMapper;
    /**
     * 文件保存
     * 1.遍历List<OrderSetting> list
     * 2.判断当前的日期之前是否设置过
     * 	2.1 设置过, 更新数量
     * 	2.2 没有设置过, 保存
     * @param lists
     */
    @Override
    public void add(List<String[]> lists) {
        //遍历list  1.遍历List<OrderSetting> list
        for (String[] str : lists) {
            //日期转date
            OrderSetting orderSetting = new OrderSetting(new Date(str[0]),Integer.parseInt(str[1]));
            //2.判断当前的日期之前是否设置过(查询记录数)
            int count=orderSettingMapper.getCountByOrderDate(orderSetting.getOrderDate());
            if (count != 0 ){
                // 设置过, 更新数量 (根据预约人数修改可预约日期) 如果设置过预约日期，更新number数量
                   orderSettingMapper.updateNumberByOrderDate(orderSetting);
            }else{
            // 如果没有设置过预约日期，执行保存
                orderSettingMapper.addOrderSetting(orderSetting);
            }
        }


    }

    @Override
    public List<Map> getOrderSettingByMonth(String orderDate) {
String startDate=orderDate+"-1";//年月-1
String endDate=orderDate+"-31";//年月-31  就是一个月从1号 到  31号的日期
List<OrderSetting> orderSettingList = orderSettingMapper.getOrderSettingByMonth(startDate, endDate);
List<Map> list=new ArrayList<>();
for (OrderSetting orderSetting : orderSettingList) {
    Map map = new HashMap();
    //除id以外的字段添加入map
    map.put("date", orderSetting.getOrderDate().getDate());
    map.put("number", orderSetting.getNumber());
    map.put("reservations", orderSetting.getReservations());
    list.add(map);
    //map加进list
}
return list;
    }

    @Override
    public void updateNumberByOrderDate(OrderSetting orderSetting) {
        //根据预约日期查询满足条件的数据的记录数
        int count = orderSettingMapper.getCountByOrderDate(orderSetting.getOrderDate());
        //判断当前的预约日期是否已经有相应的预约设置
        if(count == 0){
            //当前日期没有预约设置信息，则添加
            orderSettingMapper.addOrderSetting(orderSetting);
        }else{
            //当前日期已经存在预约设置信息，则修改可预约人数
            orderSettingMapper.updateNumberByOrderDate(orderSetting);
        }
        }

    }




