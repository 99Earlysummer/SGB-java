import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

/**
 * @author ***
 * @create 2021-12-13 23:22
 */
public class MyservletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //监听ServletContext创建(监听服务器启动)
        System.out.println("监听ServletContext创建(监听服务器启动)-MyServletContextListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //监听ServletContext销毁(监听服务器关闭)
        System.out.println("监听ServletContext销毁(监听服务器关闭)-MyServletContextListener contextDestroyed");
    }
}
