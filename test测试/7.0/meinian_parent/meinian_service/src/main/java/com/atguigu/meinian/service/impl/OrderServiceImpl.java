package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.mapper.MemberMapper;
import com.atguigu.meinian.mapper.OrderMapper;
import com.atguigu.meinian.mapper.OrderSettingMapper;
import com.atguigu.meinian.pojo.Member;
import com.atguigu.meinian.pojo.Order;
import com.atguigu.meinian.pojo.OrderSetting;
import com.atguigu.meinian.service.OrderService;
import com.atguigu.meinian.uilts.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Service(interfaceClass = OrderService.class)
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderSettingMapper orderSettingMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MemberMapper memberMapper;



    @Override
    public Result submitOrder(Map map) throws Exception {
        //获取预约日期
        String orderDateStr = (String) map.get("orderDate");
        Date orderDate = DateUtils.parseString2Date(orderDateStr);
        //查询预约设置表，判断是否有该记录
        //条件:预约日期 查询:预约设置信息，  判断当前的预约日期是否可以预约
        OrderSetting orderSetting=orderSettingMapper.getOrderSettingByOrderDate(orderDate);
        if (orderSetting == null) {
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }else{
            //如果有，说明预约可以进行预约，
            // 可预约人数
            int number = orderSetting.getNumber();
            //已预约人数
            int reservations = orderSetting.getReservations();
            //匹配
            if (number<=reservations){
                return new Result(false,MessageConstant.ORDER_FULL);
            }
        }
//判断手机号是否已注册会员
        String telephone = (String) map.get("telephone");
        //查询会员表，判断当前预约人是否是会员
        System.out.println("memberMapper = " + memberMapper);
        Member member=memberMapper.findMemberByTelephone(telephone);
        if (member==null){
            //标识当前手机号没注册 帮其注册为会员
            member = new Member();
            //添加所有注册信息
            member.setName((String) map.get("name"));
            member.setSex((String) map.get("sex"));
            member.setIdCard((String) map.get("idCard"));
            member.setPhoneNumber(telephone);
            member.setRegTime(new Date());
            memberMapper.addMember(member);
        }else{
            //当前手机号已经是会员
            Order order=new Order();
            order.setMemberId(member.getId());
            order.setOrderDate(orderDate);
            order.setSetmealId(Integer.parseInt((String) map.get("setmealId")));
            //查询记录数
            int count=orderMapper.findCountByCondition(order);
            if (count>0){
                return new Result(false,MessageConstant.HAS_ORDERED);
            }
        }
        //实现预约功能，将预约设置中已预约人数+1
        orderSettingMapper.updateReservationsByOrderDate(orderDate);
        Order order = new Order();
        order.setMemberId(member.getId());
        order.setOrderDate(orderDate);
        order.setOrderType(Order.ORDERTYPE_WEIXIN);
        order.setOrderStatus(Order.ORDERSTATUS_NO);
        order.setSetmealId(Integer.parseInt((String) map.get("setmealId")));
        orderMapper.addOrder(order);
        return new Result(true, MessageConstant.ORDER_SUCCESS, order.getId());
    }
        //添加id进去

        //将setmeal添加进去
        //将预约信息存到

      /*  orderSetting.setReservations(orderSetting.getReservations()+1);
        orderSettingMapper.editReservationsByOrderDate(orderSetting);
        Result result=null;
        if(result.isFlag()){
            //预约成功，发送短信通知，短信通知内容可以是“预约时间”，“预约人”，“预约地点”，“预约事项”等信息。
            String orderDate = (String) map.get("orderDate");
            try {
                SMSUtils.sendShortMessage(telephone,orderDate);
            } catch (ClientException e) {
                e.printStackTrace();
            }*/
//（3）可以进行预约，更新预约设置表中预约人数的值，使其的值+1
            //可以预约，设置预约人数加一



    @Override
    public Map findById(Integer id) {
        System.out.println("id = " + id);
        return orderMapper.findById(id);
    }
}
































