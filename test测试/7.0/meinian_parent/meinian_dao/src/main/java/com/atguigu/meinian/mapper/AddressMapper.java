package com.atguigu.meinian.mapper;

import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.pojo.Address;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Date:2022/1/23
 * Description:
 */
public interface AddressMapper {

    /**
     * 查询所有的分公司地址信息
     * @return
     */
    List<Address> findAllMaps();

    /**
     * 添加地址
     * @param address
     */
    void addAddress(Address address);

    /**
     * 分页查询
     * @param queryString
     * @return
     */
    Page<Address> findPages(@Param("queryString") String queryString);

    /**
     * 删除地址
     * @param id
     */
    void deleteById(Integer id);
    /**
     *
     * @param
     * @return
     */

}
