package com.atguigu.job;

import com.atguigu.meinian.constant.QiniuUtils;
import com.atguigu.meinian.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Date:2022/1/18
 * Author:ybc
 * Description:
 */
@Component
public class ClearImgJob {

    @Autowired
    private JedisPool jedisPool;

    public void clearImg(){
        //通过获取差集的方式获取七牛云空间中的垃圾图片的名称
        Set<String> set = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        //将垃圾图片从七牛云中删除
        for (String fileName : set) {
            //从七牛云中删
            QiniuUtils.deleteFileFromQiniu(fileName);
            //从数据库中删
            jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES,fileName);
            System.out.println("删除的文件："+fileName);
        }
    }

}
