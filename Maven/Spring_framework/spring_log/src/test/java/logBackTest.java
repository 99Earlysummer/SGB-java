import com.sgb.pojo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-24 14:34
 */
public class logBackTest {
    Logger logger= LoggerFactory.getLogger(logBackTest.class);
    @Test
    public void logtest01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println("user = " + user);
        logger.debug("user :="+user);
        logger.info("info ... user : " + user);
        logger.warn("warn ... user : " + user);
        logger.error("error ... user : " + user);

    }
}
