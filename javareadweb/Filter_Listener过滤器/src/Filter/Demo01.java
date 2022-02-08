package Filter;

import javax.servlet.*;

import java.io.IOException;


/**
 * @author ***
 * @create 2021-12-13 9:13
 */
public class Demo01 implements Filter {
    /**
     * 定义类并实现Filter接口
     * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo01停车检查");
        //放行请求
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("Demo01"+1/0);
        System.out.println("Demo01放行");

    }
}
