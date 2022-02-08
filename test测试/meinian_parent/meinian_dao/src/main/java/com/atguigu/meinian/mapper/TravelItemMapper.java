package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.TravelItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TravelItemMapper {

    void add(TravelItem travelItem) ;

    Page<TravelItem> findPage(@Param("queryString") String queryString);

    void delete(@Param("id") Integer id);

    void update(TravelItem travelItem);

    TravelItem findById(@Param("id")  Integer id);


}
