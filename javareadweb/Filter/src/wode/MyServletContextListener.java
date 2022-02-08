package wode;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ***
 * @create 2021-12-14 1:15
 */
public class MyServletContextListener  implements ServletContextListener{
    /**
     * 监听服务器的启动
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("恭喜你!!");
    }

    /**
     * 监听服务器的关闭(资源的关闭)
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("兄弟我来了");
    }
}
