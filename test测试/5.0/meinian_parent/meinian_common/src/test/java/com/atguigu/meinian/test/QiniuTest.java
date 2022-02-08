package com.atguigu.meinian.test;

import com.atguigu.meinian.constant.QiniuUtils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.Test;

/**
 * Date:2022/1/18
 * Author:ybc
 * Description:
 */
public class QiniuTest {
    //@Test
    public void uploadFile(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());//华南
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "SJsdGZFGyQyXhNE2QejJZMU-L4dEsEmGWJrSNQ4K";
        String secretKey = "DrCmh2OKK_vyd3kYJ6NqmCmZzzd3b0hLCzUUisQx";
        String bucket = "sgb-image";
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png，可支持中文
        String localFilePath = "C:\\Users\\沈功波\\Downloads\\bf633def94d77dabd60b4f9708216a7c.jpeg";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);// FspfyEyKfuHZ0kcbXRIc5T9YhCax
            System.out.println(putRet.hash);// FspfyEyKfuHZ0kcbXRIc5T9YhCax
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    //@Test
    public void deleteFile(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        String accessKey = "SJsdGZFGyQyXhNE2QejJZMU-L4dEsEmGWJrSNQ4K";
        String secretKey = "DrCmh2OKK_vyd3kYJ6NqmCmZzzd3b0hLCzUUisQx";
        String bucket = "sgb-image";
        String key = "FqJHZ_yhcrUSCY0XAZJxxTtK-s06";//文件名称七牛云上的文件etag码
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }

    //@Test
    public void testQiniuUtils1(){
        /*七牛云的文件名*/
        QiniuUtils.deleteFileFromQiniu("test.jpg");
    }
    //@Test
    public void testQiniuUtils2(){
        /*参数1:本地或者其他地方的图片路径   参数2:上传七牛云后的文件名称*/
        QiniuUtils.upload2Qiniu("C:\\Users\\沈功波\\Downloads\\edc93ac6a76a5f817caaec65badb1b40.jpg","test.jpg");
    }
}
