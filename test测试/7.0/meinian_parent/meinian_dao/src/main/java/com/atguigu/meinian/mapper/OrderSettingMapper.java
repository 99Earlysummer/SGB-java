package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.OrderSetting;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderSettingMapper {

/*查询记录数*/
    int getCountByOrderDate(@Param("orderDate") Date orderDate);
/*更新*/
    void updateNumberByOrderDate(OrderSetting orderSetting);
/*新增*/
    void addOrderSetting(OrderSetting orderSetting);

    /**
     *
     * @return list
     */
    List<OrderSetting> getOrderSettingByMonth(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 将预约日期作为条件查询预约设置信息，判断当前的预约日期是否可以预约
     * @param orderDate
     * @return
//     *///getOrderSettingByOrderDate  getOrderSettingByOrderDate
    OrderSetting getOrderSettingByOrderDate(@Param("orderDate") Date orderDate);

    /**
     * 实现预约功能，将预约设置中已预约人数+1，并保存预约信息
     * @param orderDate
     */
    void updateReservationsByOrderDate(@Param("orderDate") Date orderDate);
}
