import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-24 19:17
 */
public class springtest {
    private ClassPathXmlApplicationContext applicationContext=null;
    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
    }
    @Test
    public void test001(){
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }
}
