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
        String accessKey = "4k6T7lNfzzIWWeE9oKeIba1WDusutJX2bsEeBmf1";
        String secretKey = "XX7-hOal6WVQIRYvTLGdks33o0lB6E1lBN4x7ToR";
        String bucket = "sgb-image";
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png，可支持中文
        String localFilePath = "D:\\setmeal.jpg";
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
        String accessKey = "4k6T7lNfzzIWWeE9oKeIba1WDusutJX2bsEeBmf1";
        String secretKey = "XX7-hOal6WVQIRYvTLGdks33o0lB6E1lBN4x7ToR";
        String bucket = "wh1018-meinian";
        String key = "Fg6BvOQENtClQ6UCL2pXfrWUnrEC";//文件名称
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
    public void testQiniuUtils(){
        QiniuUtils.deleteFileFromQiniu("29be11fc-7702-4f6f-af9b-fa13ee103816.jpg");
    }
}
