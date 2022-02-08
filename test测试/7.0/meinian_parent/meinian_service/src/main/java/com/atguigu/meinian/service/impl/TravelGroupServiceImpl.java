package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.mapper.TravelGroupMapper;
import com.atguigu.meinian.mapper.TravelItemMapper;
import com.atguigu.meinian.pojo.TravelGroup;
import com.atguigu.meinian.pojo.TravelItem;
import com.atguigu.meinian.service.TravelGroupService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = TravelGroupService.class)
@Transactional
public class TravelGroupServiceImpl implements TravelGroupService {

    @Autowired
    private TravelGroupMapper travelGroupMapper;
    @Autowired
    private TravelItemMapper travelItemMapper;

    @Override
    public void add(TravelGroup travelGroup, Integer[] travelItemIds) {
        //添加跟团游
        travelGroupMapper.addTravelGroup(travelGroup);
        //添加中间表信息
        travelGroupMapper.addTravelGroupAndTravelItem(travelGroup.getId(),travelItemIds);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
//开启插件
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
         Page<TravelGroup> page = travelGroupMapper.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());

    }



    @Override
    public void delete(Integer id) {
        //先删除中间表信息
        travelGroupMapper.deleteTravelGroupAndTravelItemByTravelGroupId(id);
        //删除跟团游信息
        travelGroupMapper.deleteTravelGroup(id);
    }

    @Override
    public Map<String, Object> findEditData(Integer id) {
        Map<String, Object> map =new HashMap<>();
        //获取跟团游信息
        TravelGroup travelGroup=travelGroupMapper.findById(id);
        List<TravelItem> travelItemList = travelItemMapper.findAll();
        //获取自由行的id
        List<Integer> travelItemIds = travelGroupMapper.findTravelItemIdsByTravelGroupId(id);
        map.put("travelGroup", travelGroup);
        map.put("travelItemList", travelItemList);
        map.put("travelItemIds", travelItemIds);
        return map;
    }

    @Override
    public void update(TravelGroup travelGroup, Integer[] travelItemIds) {
        //修改跟团游信息
        travelGroupMapper.updateTravelGroup(travelGroup);
        //删除中间表信息
        travelGroupMapper.deleteTravelGroupAndTravelItemByTravelGroupId(travelGroup.getId());
        //添加中间表信息
        travelGroupMapper.addTravelGroupAndTravelItem(travelGroup.getId(), travelItemIds);
    }

    @Override
    public List<TravelGroup> findAll() {
        return travelGroupMapper.findAll();
    }

}
