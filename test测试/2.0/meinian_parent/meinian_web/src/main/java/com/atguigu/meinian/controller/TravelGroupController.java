package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.TravelGroup;
import com.atguigu.meinian.service.TravelGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/travelGroup")
public class TravelGroupController {
    //在controller层访问  属于远程访问
    @Reference
private TravelGroupService travelGroupService;

    /**
     * 添加
     * @param travelGroup
     * @param travelItemIds
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TravelGroup travelGroup, Integer[] travelItemIds){
        /*         相当于前端也页面中的 dataFrom        travelItemIds[]*/
        try {
            travelGroupService.add(travelGroup,travelItemIds);
            return new Result(true, MessageConstant.ADD_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELGROUP_FAIL);
        }
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return  travelGroupService.findPage(queryPageBean);
    }
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            travelGroupService.delete(id);
            return new Result(true,MessageConstant.DELETE_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_TRAVELGROUP_FAIL);
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TravelGroup travelGroup,Integer[] travelItemIds){
        try {
            travelGroupService.update(travelGroup,travelItemIds);
            return new Result(true,MessageConstant.EDIT_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_TRAVELGROUP_FAIL);
        }

    }
    @RequestMapping("/findEditData")
    public Result findEditData(Integer id){
        try {
            Map<String, Object> map = travelGroupService.findEditData(id);
            return new Result(true, MessageConstant.QUERY_TRAVELGROUP_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELGROUP_FAIL);
        }
    }
    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<TravelGroup> list=travelGroupService.findAll();
            return new Result(true,MessageConstant.QUERY_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_TRAVELGROUP_FAIL);
        }
    }
}
