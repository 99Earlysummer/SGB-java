package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.pojo.OrderSetting;
import com.atguigu.meinian.service.OrderSettingService;
import com.atguigu.meinian.uilts.POIUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderSetting")
public class OrderSettingController {

    @Reference
    private OrderSettingService orderSettingService;

    /**
     * 上传文件
     * @param excelFile
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile excelFile)  {
        try {
            //使用工具类中的方法读取文件'---文件数据内容 list<>行  string[]列单元格
            List<String[]> lists = POIUtils.readExcel(excelFile);
            //调用业务层--保存操作  参数:orderSettings集合   返回:Result
            orderSettingService.add(lists);
            return new Result(true, MessageConstant.UPLOAD_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(true, MessageConstant.UPLOAD_F);
        }
        }

    /**
     *
     * @param orderDate
     * @return
     */
    @RequestMapping("/getOrderSettingByMonth")
        public Result getOrderSettingByMonth(String orderDate){
            try {
                List<Map> list=orderSettingService.getOrderSettingByMonth(orderDate);
                return new Result(true,MessageConstant.GET_ORDERSETTING_SUCCESS,list);

            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false,MessageConstant.GET_ORDERSETTING_FAIL);
            }
        }

        @RequestMapping("/updateNumberByOrderDate")
        public Result updateNumberByOrderDate(@RequestBody OrderSetting orderSetting){
            try {
                orderSettingService.updateNumberByOrderDate(orderSetting);
                return new Result(true,MessageConstant.ORDERSETTING_SUCCESS);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false,MessageConstant.ORDERSETTING_FAIL);
            }
        }
    }


