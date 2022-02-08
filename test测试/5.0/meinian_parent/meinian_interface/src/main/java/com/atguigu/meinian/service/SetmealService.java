package com.atguigu.meinian.service;

import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.pojo.Setmeal;

import java.util.List;

public interface SetmealService {
    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    void add(Setmeal setmeal, Integer[] travelGroupIds);

    /**
     * 移动端详情页信息
     * @return
     */
    List<Setmeal> findAll();
}
