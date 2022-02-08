package com.atguigu.meinian.service;


import com.atguigu.meinian.pojo.Address;

import java.util.List;

/**
 * Date:2022/1/23
 * Author:ybc
 * Description:
 */
public interface AddressService {

    /**
     * 查询所有分公司地址
     * @return
     */
    List<Address> findAllMaps();
}
