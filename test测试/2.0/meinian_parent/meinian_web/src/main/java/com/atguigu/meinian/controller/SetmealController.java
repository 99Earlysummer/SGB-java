package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.container.page.PageHandler;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.Setmeal;
import com.atguigu.meinian.service.SetmealService;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealService setmealService;

/*    @RequestMapping("/upload")
    public Result upload(MultipartFile imgFile){
        return  setmealService.upload(imgFile);

    }*/

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
          return   setmealService.findPage(queryPageBean);
    }

}
