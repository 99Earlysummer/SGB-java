package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.constant.RedisMessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.Setmeal;
import com.atguigu.meinian.service.SetmealService;
import com.atguigu.meinian.uilts.SMSUtils;
import com.atguigu.meinian.uilts.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ValueConstants;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealMobileController {
    @Reference
    private SetmealService setmealService;

    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            List<Setmeal> list = setmealService.findAll();
            return new Result(true,MessageConstant.GET_SETMEAL_LIST_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_SETMEAL_LIST_FAIL);
        }
    }

    /**
     *  //根据套餐id查询套餐的信息 以及套餐游里面所有跟团游的信息
     *  //
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById( Integer id){
        try {
            Setmeal setmeal=setmealService.findById(id);
            return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }



}
