package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Setmeal;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SetmealMapper {



    Page<Setmeal> findPage(@Param("queryString") String queryString);

    /**
     * 添加套餐行表
     * @param setmeal
     */
    void addSetmeal(Setmeal setmeal);

    /**
     * 添加中间表
     * @param id
     * @param travelGroupIds
     */
    void addSetmealAndTravelGroup(@Param("id") Integer id,@Param("travelGroupIds") Integer[] travelGroupIds);

    /**
     * 消费者移动端
     * @return
     */
    List<Setmeal> findAll();

    Setmeal findById(Integer id);

    void deleteTravelGroupAndTravelItemByTravelGroupId(@Param("id") Integer id);

    void deleteTravelGroup(@Param("id") Integer id);

    List<Map> getSetmealData();

    List<Map> getHotSetmeal();
}
