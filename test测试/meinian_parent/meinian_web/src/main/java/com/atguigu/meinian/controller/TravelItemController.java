package com.atguigu.meinian.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.service.TravelItemService;
import com.atguigu.meinian.pojo.TravelItem;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //自动装配(当两类较近时)较远时用远程调用@Reference
@RequestMapping("/travelItem")
public class TravelItemController {

    @Reference
    private TravelItemService travelItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody TravelItem travelItem){
        try {
            travelItemService.add(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return travelItemService.findPage(queryPageBean);

    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            travelItemService.delete(id);
            return new Result(true, MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            TravelItem travelItem = travelItemService.findById(id);
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, travelItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TravelItem travelItem){
        try {
            travelItemService.update(travelItem);
            return new Result(true, MessageConstant.EDIT_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_TRAVELITEM_FAIL);
        }
    }

}






/*

@RestController
@RequestMapping("/travelItem")
public class TravelItemController {
    @Reference
    private TravelItemService travelItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody TravelItem travelItem){
        try {
            travelItemService.add(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELITEM_FAIL);
        }
    }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
      return   travelItemService.findPage(queryPageBean);
    }

    @RequestMapping("/delete")
    public void delete(Integer id){
        travelItemService.delete(id);
    }
    @RequestMapping("/updata")
    public Result updata(@RequestBody TravelItem travelItem){
        try {
            travelItemService.update(travelItem);
            return new Result(true,MessageConstant.EDIT_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_TRAVELITEM_FAIL);
        }
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            TravelItem travelItem = travelItemService.findById(id);
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, travelItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        }
    }



    }

*/
