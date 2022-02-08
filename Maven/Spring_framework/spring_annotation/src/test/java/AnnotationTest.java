import com.sgb.Dao.UserDao;
import com.sgb.controller.UserController;
import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-26 20:31
 */
public class AnnotationTest {
    private ApplicationContext applicationContext=null;

    @Before
    public void init(){
        applicationContext=new ClassPathXmlApplicationContext("spring-core.xml");
    }
    @Test
    public void test01() throws Exception {
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.selectUserList();
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.selectUserList();
        UserDao userDao = (UserDao) applicationContext.getBean("userController");
        userDao.selectUserList();
        User user = (User) applicationContext.getBean("user");
        System.out.println("user = " + user);

    }
    @Test
    public void test02() {
         UserController userController = (UserController) applicationContext.getBean("userController");
    }
}
