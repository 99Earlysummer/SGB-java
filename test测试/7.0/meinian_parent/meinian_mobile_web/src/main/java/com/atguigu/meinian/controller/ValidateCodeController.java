package com.atguigu.meinian.controller;

import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.constant.RedisMessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.uilts.SMSUtils;
import com.atguigu.meinian.uilts.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 发送验证码  携带手机号telephone
     *
     * @return
     */
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        try {
            //用工具类生成验证码
            String code = ValidateCodeUtils.generateValidateCode(4) + "";
            //用工具类发送验证码 (验证码发送失败)
            //发送
            SMSUtils.sendShortMessage(telephone, code);
            //同时将验证码存到reids中  失效时间:5分钟 jedisPool.getResource().setex()参数:手机号状态码,失效时间(5分钟),验证码
            jedisPool.getResource().setex(telephone + ":" + RedisMessageConstant.SENDTYPE_ORDER, 2400 * 5 * 60, code);
            return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
            //验证成功
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }

    }
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone){
        try {
            //用工具类生成验证码
            String code = ValidateCodeUtils.generateValidateCode(4) + "";
            //用工具类发送验证码 (验证码发送失败)
            //发送
            SMSUtils.sendShortMessage(telephone, code);
            //同时将验证码存到reids中  失效时间:5分钟 jedisPool.getResource().setex()参数:手机号状态码,失效时间(5分钟),验证码
            jedisPool.getResource().setex(telephone + ":" + RedisMessageConstant.SENDTYPE_LOGIN, 5 * 60, code);
            return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
            //验证成功
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
    }

}
