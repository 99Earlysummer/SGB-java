package com.atguigu.meinian.service;

import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.pojo.Setmeal;

import java.util.List;
import java.util.Map;

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

    Setmeal findById(Integer id);

    void delete(Integer id);

    /**
     * 获取所有的预约信息
     * @return
     */
    List<Map> getSetmealData();


    /**
     * //根据套餐id查询套餐的信息 以及套餐游里面所有跟团游的信息
     * @param id
     */

}
