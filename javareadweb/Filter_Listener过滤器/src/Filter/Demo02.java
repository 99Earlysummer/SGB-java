package Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-13 18:08
 */
public class Demo02 implements Filter {
    private String name ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      name=filterConfig.getInitParameter("name");
        System.out.println("Demo02初始化中... 输出name:"+name);
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Demo02过滤器中时输出name:"+name);
    }
    @Override
    public void destroy() {
        System.out.println("Demo02正在关闭资源...");
    }
}
