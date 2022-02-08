import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-24 18:04
 */
public class LifeTest {
    private ClassPathXmlApplicationContext applicationContext=null;
    @Before
    public void init(){
        //初始化spring
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
    }
    @Test
    public void test01(){
        Object user = applicationContext.getBean("user");
        Object user1 = applicationContext.getBean("user");
        System.out.println( user1 == user);
        applicationContext.close();
    }
}
