import com.sgb.pojo.Bean01;
import com.sgb.pojo.Bean02;
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
        Bean01 bean01   = (Bean01) applicationContext.getBean("bean01");
        System.out.println("bean01 = " + bean01);
    }
    @Test
    public void bean2(){
        //初始化spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        Bean02 bean02 = (Bean02) applicationContext.getBean("bean02");
        System.out.println("bean02 = " + bean02);
    }
}
