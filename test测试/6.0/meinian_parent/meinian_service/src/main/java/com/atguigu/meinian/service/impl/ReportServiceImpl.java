package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.mapper.MemberMapper;
import com.atguigu.meinian.mapper.OrderMapper;
import com.atguigu.meinian.mapper.SetmealMapper;
import com.atguigu.meinian.service.ReportService;
import com.atguigu.meinian.uilts.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date:2022/1/23
 * Description:
 */
@Service(interfaceClass = ReportService.class)
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    /**
     * reportDate:null, // 日期
     * todayNewMember :0, // 今日新增会员数
     * totalMember :0,// 总会员数
     * thisWeekNewMember :0,// 本周新增会员数
     * thisMonthNewMember :0,// 本月新增会员数
     * todayOrderNumber :0,// 今日预约数
     * todayVisitsNumber :0,// 今日出游数
     * thisWeekOrderNumber :0,// 本周预约数
     * thisWeekVisitsNumber :0,// 本周出游数
     * thisMonthOrderNumber :0,// 本月预约数
     * thisMonthVisitsNumber :0,// 本月出游数
     * hotSetmeal :热门套餐
     */

    @Override
    public Map getBusinessReportData() throws Exception {
        //获取系统当前时间
        Date now = new Date();
        //将日期类型的系统当前时间转换字符串类型
        String reportDate = DateUtils.parseDate2String(now);
        //获取本周一和周日的日期
        Date thisWeekMonday = DateUtils.getThisWeekMonday();
        Date thisWeekSunday = DateUtils.getSundayOfThisWeek();
        //获取本月第一天和最后一天的日期
        Date thisMonthFirstDay = DateUtils.getFirstDay4ThisMonth();
        Date thisMonthLastDay = DateUtils.getLastDay4ThisMonth();
        //todayNewMember:今日新增会员数
        Integer todayNewMember = memberMapper.getTodayNewMember(reportDate);
        //totalMember:总会员数
        Integer totalMember = memberMapper.getTotalMember();
        //thisWeekNewMember:本周新增会员数
        Integer thisWeekNewMember = memberMapper.getThisWeekAndMonthNewMember(thisWeekMonday);
        //thisMonthNewMember:本月新增会员数
        Integer thisMonthNewMember = memberMapper.getThisWeekAndMonthNewMember(thisMonthFirstDay);
        //todayOrderNumber:今日预约数
        Integer todayOrderNumber = orderMapper.getTodayOrderNumber(reportDate);
        //todayVisitsNumber:今日出游数
        Integer todayVisitsNumber = orderMapper.getTodayVisitsNumber(reportDate);
        //thisWeekOrderNumber:本周预约数
        Integer thisWeekOrderNumber = orderMapper.getThisWeekAndMonthOrderNumber(thisWeekMonday, thisWeekSunday);
        //thisWeekVisitsNumber:本周出游数
        Integer thisWeekVisitsNumber = orderMapper.getThisWeekAndMonthVisitsNumber(thisWeekMonday, thisWeekSunday);
        //thisMonthOrderNumber:本月预约数
        Integer thisMonthOrderNumber = orderMapper.getThisWeekAndMonthOrderNumber(thisMonthFirstDay, thisMonthLastDay);
        //thisMonthVisitsNumber:本月出游数
        Integer thisMonthVisitsNumber = orderMapper.getThisWeekAndMonthVisitsNumber(thisMonthFirstDay, thisMonthLastDay);
        //hotSetmeal :热门套餐
        List<Map> hotSetmeal = setmealMapper.getHotSetmeal();
        Map map = new HashMap();
        map.put("reportDate", reportDate);
        map.put("todayNewMember", todayNewMember);
        map.put("totalMember", totalMember);
        map.put("thisWeekNewMember", thisWeekNewMember);
        map.put("thisMonthNewMember", thisMonthNewMember);
        map.put("todayOrderNumber", todayOrderNumber);
        map.put("todayVisitsNumber", todayVisitsNumber);
        map.put("thisWeekOrderNumber", thisWeekOrderNumber);
        map.put("thisWeekVisitsNumber", thisWeekVisitsNumber);
        map.put("thisMonthOrderNumber", thisMonthOrderNumber);
        map.put("thisMonthVisitsNumber", thisMonthVisitsNumber);
        map.put("hotSetmeal", hotSetmeal);
        return map;
    }
}
