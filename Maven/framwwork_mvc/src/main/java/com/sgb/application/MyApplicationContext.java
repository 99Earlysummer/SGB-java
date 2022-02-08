package com.sgb.application;


import javax.xml.bind.Element;
import java.util.HashMap;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-24 9:20
 */
public class MyApplicationContext {
    private HashMap<String, Object> map = new HashMap<>();
    public MyApplicationContext() {
        parseXML();
    }

    private void parseXML() {
        SAXReader saxReader = new SAXReader();
        try {
            Document document=saxReader.read(MyApplicationContext.class.getClassLoader().getResourceAsStream("beans.xml"));
            Element rootElement=document.getRootElements();
            List<Element> beanEles=rootElement.elements("bean");
            for (Element beanEle : beanEles) {
                String id=beanEle.attribute("id").getValue();
                Srting className=beanEle.attributeValue("class");
                Object instance = Class.forName(className).newInstance();
                map.put(id,instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  Object getBean(String className){
        /*
        原因:ifelse过多难维护  因此用反射
        if (beanName.equals("userService")){
            return  new UserServiceImpl();
        }else if (beanName.equals("userMapper")){
            return new UserMapperImpl();
        }else if (beanName.equals("user")){
            return new User(1,"zhangsan","ssf");
        }
        return null;*/

        /*
        Object o= null;
        try {
            o= Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;*/
    return map.get(beanName);

    }
}
