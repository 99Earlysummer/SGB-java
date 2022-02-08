package com.atguigu.meinian.mapper;

import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.pojo.Setmeal;
import com.github.pagehelper.Page;

public interface SetmealMapper {
    Page<Setmeal> findPage(String queryString);

    /**
     * 查询页数
     * @param queryPageBean
     * @return
     */

}
