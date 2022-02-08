import com.sgb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-24 13:20
 */
public class IOCTest {
    @Test
    public void test01(){
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
