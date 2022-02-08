package com.atguigu.meinian.mapper;


import com.atguigu.meinian.pojo.TravelGroup;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TravelGroupMapper {


    Page<TravelGroup> findPage(@Param("queryString")String queryString);

    void addTravelGroup(TravelGroup travelGroup);

    void deleteTravelGroup(@Param("id") Integer id);


    /**
     * 获取跟团游所对应的自由行的id
     * @param id
     * @return
     */
    List<Integer> findTravelItemIdsByTravelGroupId(@Param("id") Integer id);


    void updateTravelGroup(TravelGroup travelGroup);
    void deleteTravelGroupAndTravelItemByTravelGroupId(@Param("id") Integer id);
    void addTravelGroupAndTravelItem(@Param("travelGroupId") Integer travelGroupId, @Param("travelItemIds") Integer[] travelItemIds);

    TravelGroup findById(@Param("id") Integer id);

    List<TravelGroup> findAll();

    List<TravelGroup> findTravelGroupBySetmealId(@Param("id") Integer id);
}
