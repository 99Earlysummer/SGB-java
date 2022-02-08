package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.mapper.AddressMapper;
import com.atguigu.meinian.pojo.Address;
import com.atguigu.meinian.pojo.TravelGroup;
import com.atguigu.meinian.service.AddressService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public void addAddress(Address address) {
        addressMapper.addAddress(address);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPages(QueryPageBean queryPageBean) {
        //开启分页
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<Address> page = addressMapper.findPages(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());

    }

    @Override
    public void deleteById(Integer id) {
        addressMapper.deleteById(id);
    }
}
