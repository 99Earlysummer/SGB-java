package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.constant.QiniuUtils;
import com.atguigu.meinian.constant.RedisConstant;
import com.atguigu.meinian.entity.PageResult;
import com.atguigu.meinian.entity.QueryPageBean;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.Setmeal;
import com.atguigu.meinian.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealService setmealService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            setmealService.delete(id);
            return new Result(true,MessageConstant.DELETE_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_TRAVELGROUP_FAIL);
        }
    }

    @RequestMapping("/upload")
    public Result upload(MultipartFile imgFile){//后端接收前端上传的文件MultipartFile  前端文件属性名
        try {
            //获取上传文件的所有字节
            byte[] bytes = imgFile.getBytes();
            //获取上传文件的文件名
            String fileName = imgFile.getOriginalFilename();
            //获取上传文件的后缀名
            String hzName = fileName.substring(fileName.lastIndexOf("."));
            //获取随机序列UUID
            String uuid = UUID.randomUUID().toString();
            //获取新的文件名
            fileName = uuid + hzName;
            //将文件上传到七牛云
            QiniuUtils.upload2Qiniu(bytes, fileName);
            //在上传成功时将文件名存储到redis中
           jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, fileName);
            return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
          return   setmealService.findPage(queryPageBean);
    }

    @RequestMapping("/add")
    public Result  add(@RequestBody Setmeal setmeal, Integer[] travelGroupIds){
        try {
            setmealService.add(setmeal, travelGroupIds);
            //将数据库中的文件名存储到redis中

           //jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());
            return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
        }
    }



}
