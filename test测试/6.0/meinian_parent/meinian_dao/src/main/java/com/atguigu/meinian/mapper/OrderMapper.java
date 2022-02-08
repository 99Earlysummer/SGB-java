package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderMapper {


    /**
     * 判断该会员是否预约了同一天的同一个套餐  如果有数量那就说明预约了多的
     * @param order
     * @return
     */
    int findCountByCondition(@Param("order") Order order);

    /**
     * 将预约信息存到数据库中
     * @param order
     */
    void addOrder(Order order);

    Map findById(@Param("id") Integer id);
    /**
     * 获取今日预约数
     * @param reportDate
     * @return
     */
    Integer getTodayOrderNumber(@Param("orderDate") String reportDate);

    /**
     * 获取今日出游数
     * @param reportDate
     * @return
     */
    Integer getTodayVisitsNumber(@Param("orderDate") String reportDate);

    /**
     * 查询本周或本月预约数
     * @param startDate
     * @param endDate
     * @return
     */
    Integer getThisWeekAndMonthOrderNumber(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    Integer getThisWeekAndMonthVisitsNumber(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /**
     * 查询本周或本月出游数
     * @param startDate
     * @param endDate
     * @return
     */



}
