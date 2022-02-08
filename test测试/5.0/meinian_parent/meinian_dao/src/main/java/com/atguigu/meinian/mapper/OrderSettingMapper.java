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
}
