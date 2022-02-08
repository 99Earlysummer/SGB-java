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

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    /**
     * 查询所有的套餐游信息
     * @return
     */
    @Override
    public List<Setmeal> findAll() {
        return setmealMapper.findAll();
    }

    /**
     * 根据套餐id查询套餐的信息 以及套餐游里面所有跟团游的信息
     * @param id
     */
    @Override
    public Setmeal findById(Integer id) {
        System.out.println("id = " + id);
          return   setmealMapper.findById(id);

    }
/*void delete(Integer id);*/
    @Override
    public void delete(Integer id) {
        //先删除中间表信息
        setmealMapper.deleteTravelGroupAndTravelItemByTravelGroupId(id);
        //删除跟团游信息
        setmealMapper.deleteTravelGroup(id);
    }

    /**
     * 获取所有的预约信息
     * @return
     */
    @Override
    public List<Map> getSetmealData() {

        return setmealMapper.getSetmealData();
    }

}
