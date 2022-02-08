package com.atguigu.meinian.service;


import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.pojo.TravelGroup;

import java.util.List;
import java.util.Map;


public interface TravelGroupService {


    void add(TravelGroup travelGroup, Integer[] travelItemIds);

    PageResult findPage(QueryPageBean queryPageBean);

    void delete(Integer id);

    /**
     * 查询编辑功能的回显数据
     * @param id
     * @return
     */
    Map<String, Object> findEditData(Integer id);

    void update(TravelGroup travelGroup, Integer[] travelItemIds);

    List<TravelGroup> findAll();
}
