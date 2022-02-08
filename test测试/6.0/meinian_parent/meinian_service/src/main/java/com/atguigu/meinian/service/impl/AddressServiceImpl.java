package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.mapper.AddressMapper;
import com.atguigu.meinian.pojo.Address;
import com.atguigu.meinian.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date:2022/1/23
 * Description:
 */
@Service(interfaceClass = AddressService.class)
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAllMaps() {
        return addressMapper.findAllMaps();
    }
}
