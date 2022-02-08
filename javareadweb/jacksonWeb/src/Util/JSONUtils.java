package Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-15 10:25
 */
public class JSONUtils {
    /**
     *将java对象转换为json字符串
     * @param obj
     * @return
     */
    public static String javaBean2JsonStr(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    /**
     *将json字符串转换为java对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonStr2Javabean(String str ,Class<T> clazz) throws IOException {
        return new ObjectMapper().readValue(str,clazz);
    }

    /**
     * 1，获取请求正文json
     * 2,将json字符串转换为java对象
     *
     * @param <T>
     * @return
     */
    public static <T> T readRequest2Javabean(HttpServletRequest request, Class<T> clazz) throws Exception {
        //1.1，获取请求正文json
        BufferedReader bufferedReader = request.getReader();
        String content = null;
        StringBuilder sb = new StringBuilder();
        while ((content = bufferedReader.readLine()) != null) {
            sb.append(content);
        }
        String inputJsonStr = sb.toString();
        //1.2,将json字符串转换为java对象
        T t = JSONUtils.jsonStr2Javabean(inputJsonStr, clazz);
        return t;
    }

    /**
     * 1，将java对象转换为json字符串
     * 2，将json字符串作为响应正文返回给浏览器
     * @param response
     * @param obj
     */
    public static void writeJavabean2ResponseText(HttpServletResponse response, Object obj) throws IOException {
        String jsonStr = JSONUtils.javaBean2JsonStr(obj);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonStr);
    }


}



