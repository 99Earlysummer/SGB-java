package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Province;
import pojo.ResultVO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ***
 * @create 2021-12-15 10:15
 */
public class DemoJson转Java {
    public static void main(String[] args) throws IOException {
        //json转java单个对象
        String jsonStr1="{\"provinceId\":1,\"provinceName\":\"湖北省\",\"capital\":false}";
        Province province = new ObjectMapper().readValue(jsonStr1, Province.class);
        //json转javaList集合
        String jsonStr2="[{\"provinceId\":1,\"provinceName\":\"湖北省\",\"capital\":false},{\"provinceId\":2,\"provinceName\":\"湖南省\",\"capital\":false},{\"provinceId\":3,\"provinceName\":\"北京市\",\"capital\":true}]\n";
        List<Province> list = new ObjectMapper().readValue(jsonStr2, List.class);
        //json转javaMap集合
        String jsonStr3="\"{\\\"msg\\\":\\\"查询省份列表成功!\\\",\\\"flag\\\":true,\\\"data\\\":[{\\\"provinceId\\\":1,\\\"provinceName\\\":\\\"湖北省\\\",\\\"capital\\\":false},{\\\"provinceId\\\":2,\\\"provinceName\\\":\\\"湖南省\\\",\\\"capital\\\":false},{\\\"provinceId\\\":3,\\\"provinceName\\\":\\\"北京市\\\",\\\"capital\\\":true}]}\"";
        Map<String,Object> map = new ObjectMapper().readValue(jsonStr3, Map.class);
        System.out.println("map = " + map);
        //json转ResultVO
        String jsonStr4="\"{\\\"msg\\\":\\\"查询省份列表成功!\\\",\\\"flag\\\":true,\\\"data\\\":[{\\\"provinceId\\\":1,\\\"provinceName\\\":\\\"湖北省\\\",\\\"capital\\\":false},{\\\"provinceId\\\":2,\\\"provinceName\\\":\\\"湖南省\\\",\\\"capital\\\":false},{\\\"provinceId\\\":3,\\\"provinceName\\\":\\\"北京市\\\",\\\"capital\\\":true}]}\"";
        ResultVO resultVO=new ObjectMapper().readValue(jsonStr4,ResultVO.class);
    }
}
