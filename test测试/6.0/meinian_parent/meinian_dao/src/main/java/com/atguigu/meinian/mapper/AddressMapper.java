package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Address;

import java.util.List;

/**
 * Date:2022/1/23
 * Author:ybc
 * Description:
 */
public interface AddressMapper {

    /**
     * 查询所有的分公司地址信息
     * @return
     */
    List<Address> findAllMaps();
}
