package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-13 17:48
 */

public class Demo03 implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//初始化--对私有成员进行初始化
        encoding = filterConfig.getInitParameter("encoding");
        System.out.println("Demo03初始化阶段");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //执行过滤操作
        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Demo03过滤阶段-encoding = " + encoding);
    }
    @Override
    public void destroy() {
//执行销毁操作
        System.out.println("Demo03中的资源正在关闭...");
    }
}
