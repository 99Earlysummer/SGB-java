import com.sgb.configuration.MySpringCoreConfiguration;
import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-27 14:06
 */
@RunWith(SpringJUnit4ClassRunner.class)//加载配置
@ContextConfiguration(classes = MySpringCoreConfiguration.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void selectUserList() throws Exception {
        List<User> userList = userService.selectUserList();
        System.out.println("userList = " + userList);
    }




    /*
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-core.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        List<User> userList=userService.selectUserList();
        System.out.println("userList = " + userList);
    }*/
}
