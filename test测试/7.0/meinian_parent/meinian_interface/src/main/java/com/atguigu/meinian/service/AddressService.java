package com.atguigu.meinian.service;


import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.Address;

import java.util.List;

/**
 * Date:2022/1/23
 * Description:
 */
public interface AddressService {

    /**
     * 查询所有分公司地址
     * @return
     */
    List<Address> findAllMaps();

    /**
     * 添加地址
     * @param address
     * @return
     */
    void addAddress(Address address);

    /**
     * 查询地址
     * @param queryPageBean
     * @return
     */
    PageResult findPages(QueryPageBean queryPageBean);

    /**
     * 删除地址
     * @param id
     */
    void deleteById(Integer id);
}
