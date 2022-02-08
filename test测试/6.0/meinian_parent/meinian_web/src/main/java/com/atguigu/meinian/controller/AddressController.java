package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.pojo.Address;
import com.atguigu.meinian.service.AddressService;
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

}
