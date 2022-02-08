package Utils;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ***
 * @create 2021-12-21 1:43
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory=null;
    static {
        String config="mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            factory= new SqlSessionFactoryBuilder().build(inputStream)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession session=null;
        if (factory!=null){
            factory.openSession();
        }
        return session;
    }
}
