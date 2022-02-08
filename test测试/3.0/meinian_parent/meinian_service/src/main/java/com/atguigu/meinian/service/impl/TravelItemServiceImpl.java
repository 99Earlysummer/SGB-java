package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.mapper.TravelItemMapper;
import com.atguigu.meinian.pojo.TravelItem;
import com.atguigu.meinian.service.TravelItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(interfaceClass = TravelItemService.class)
@Transactional
public class TravelItemServiceImpl implements TravelItemService {

    @Autowired
    private TravelItemMapper travelItemMapper;

/**
 * 添加
 * @param travelItem
 * */
    @Override
    public void add(TravelItem travelItem) {
        travelItemMapper.add(travelItem);
    }

/**
 * 查询
 * @param queryPageBean
 * @return
 * */
@Override
public PageResult findPage(QueryPageBean queryPageBean) {
    //开启分页功能
    PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
    //根据条件查询自由行信息
    Page<TravelItem> page = travelItemMapper.findPage(queryPageBean.getQueryString());
    return new PageResult(page.getTotal(), page.getResult());
}

/**
 * 删除
 * @param id
 * */
    @Override
    public void delete(Integer id) {
        travelItemMapper.delete(id);
    }

/**
 * 编辑
 * @param travelItem
 * */
    @Override
    public void update(TravelItem travelItem) {
        travelItemMapper.update(travelItem);

    }

/**
 * 查询后回显
 * @param id
 * */
    @Override
    public TravelItem findById(Integer id) {
        return travelItemMapper.findById(id);
    }

    @Override
    public List<TravelItem> findAll() {
        return travelItemMapper.findAll();
    }
}





/*
@Service(interfaceClass = TravelItemService.class)
@Transactional
public class TravelItemServiceImpl implements TravelItemService {

    @Autowired
    private TravelItemMapper travelItemMapper;

    @Override
    public void add(TravelItem travelItem) {
        travelItemMapper.add(travelItem);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //开启分页功能
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        //根据条件查询自由行信息
        Page<TravelItem> page = travelItemMapper.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void delete(Integer id) {
        travelItemMapper.delete(id);
    }

    @Override
    public void update(TravelItem travelItem) {
        travelItemMapper.update(travelItem);
    }

    @Override
    public TravelItem findById(Integer id) {
        return travelItemMapper.findById(id);
    }

}
*/
