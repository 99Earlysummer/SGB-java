package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.constant.RedisMessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.service.MemberService;
import javassist.compiler.ast.CondExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginMobileController {
    @Reference
    private MemberService memberService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/check")
    public Result Login(@RequestBody Map map){
//获取手机号和验证码

        String telephone = (String) map.get("telephone");
        String validateCode = (String) map.get("validateCode");
//获取redis中正确的验证码
        String codeInRedis = jedisPool.getResource().get(telephone + ":" + RedisMessageConstant.SENDTYPE_LOGIN);
        //判断
        if (codeInRedis!=null&& codeInRedis.equals(validateCode)){
            memberService.addMember(telephone);
            return new Result(true, null);

        }else{
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }



}
