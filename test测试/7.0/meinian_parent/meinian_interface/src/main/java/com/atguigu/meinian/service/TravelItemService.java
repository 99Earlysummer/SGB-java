package com.atguigu.meinian.service;

import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.pojo.TravelItem;

import java.util.List;

/**
 * Description:
 */
public interface TravelItemService {

    /**
     * 新增
     * @param travelItem
     */
    void add(TravelItem travelItem);

    /**
     * 查询
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 编辑
     * @param travelItem
     */
    void update(TravelItem travelItem);

    /**
     * 从查询后再回显
     * @param id
     */
    TravelItem findById(Integer id);

    /**
     * 在跟团游中显示所有信息
     * @return
     */
    List<TravelItem> findAll();
}
