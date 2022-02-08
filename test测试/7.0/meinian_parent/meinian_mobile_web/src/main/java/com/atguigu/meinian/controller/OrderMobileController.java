package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.constant.RedisMessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.service.OrderService;
import com.atguigu.meinian.uilts.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderMobileController {
    @Reference
    private OrderService orderService;
    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/submit")/*页面传来的是一个表单因此在请求体中*/
    public Result submitOrder(@RequestBody Map map) {
        /*参数:??????    返回值:Resuilt()   */
/*
先获取页面中的验证码
然后获取reids中的验证码
进行校验
如果通过校验
        提交到数据库 提示预约成功  并跳转预约成功页面  再发送预约成功的短信通知
如果不通过校验
        不提交 提示预约失败  返回
 */try {
        String telephone = (String) map.get("telephone");//页面手机号
        String validateCode = (String) map.get("validateCode");//页面验证码
            String codeInRedis = jedisPool.getResource().get(telephone +":" +RedisMessageConstant.SENDTYPE_ORDER);//redis中的验证码
        //验证验证码
            if (validateCode.equals(codeInRedis) && codeInRedis != null) {
                //true   预约
                Result result = orderService.submitOrder(map);
                return result;
            } else {
                //false redis中验证码与页面验证码不匹配  页面验证码为空
                return new Result(false, MessageConstant.VALIDATECODE_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ORDER_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            System.out.println("id = " + id);
            Map map=orderService.findById(id);
            map.put("orderDate", DateUtils.parseDate2String((Date) map.get("orderDate")));
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
        }
    }

}
