package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.mapper.SetmealMapper;
import com.atguigu.meinian.pojo.Setmeal;
import com.atguigu.meinian.service.SetmealService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<Setmeal> page = setmealMapper.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(Setmeal setmeal, Integer[] travelGroupIds) {
        //添加套餐行后再去添加中间表
            setmealMapper.addSetmeal(setmeal);
            setmealMapper.addSetmealAndTravelGroup(setmeal.getId(),travelGroupIds);
        }

}
