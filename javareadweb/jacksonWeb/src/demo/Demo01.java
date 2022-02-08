package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Province;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ***
 * @create 2021-12-15 9:34
 */
public class Demo01 {
    public static void main(String[] args) throws JsonProcessingException {
       //java对象
        Province province1=new Province(1, "湖北省", false);
        //java单个对象转换json
        String jsonStr1=new ObjectMapper().writeValueAsString(province1);
        //java list集合转换json
        List<Province> list=new ArrayList<>();
        list.add(province1);
        String jsonStr2=new ObjectMapper().writeValueAsString(list);

        //list.add(province2);
        //list.add(province3);


        //java map集合转换json
        Map map=new HashMap();
        map.put("flag", true);
        map.put("msg", "查询省份列表成功!");
        map.put("data", list);
        String jsonStr3=new ObjectMapper().writeValueAsString(map);
        //javaBean对象转json


    }

}
