package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.Address;
import com.atguigu.meinian.service.AddressService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2022/1/23
 * Description:
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Reference
    private AddressService addressService;

    @RequestMapping("/findAllMaps")
    public List<Address> findAllMaps(){
        return addressService.findAllMaps();
    }

    @RequestMapping("/addAddress")
    public Result addAddress(@RequestBody Address address){
        try {
            addressService.addAddress(address);
            return new Result(true, MessageConstant.ADD_MAP_SECCASS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_MAP_FULL);
        }
    }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return addressService.findPages(queryPageBean);
    }
    @RequestMapping("/deleteById")
    public void deleteById(Integer id){
        addressService.deleteById(id);
    }
}
