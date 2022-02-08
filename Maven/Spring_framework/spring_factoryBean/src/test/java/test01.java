import com.sgb.pojo.Bean01;
import com.sgb.pojo.Bean02;
import com.sgb.pojo.Bean03;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-24 13:34
 */
public class test01 {

    @Test
    public void bean1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        Bean03 bean03 = (Bean03) applicationContext.getBean("bean03");
        System.out.println("bean03 = " + bean03);
    }




}
