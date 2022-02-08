package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-13 20:13
 */
@WebFilter(
        filterName = "zhujie",
        initParams = {
                @WebInitParam(
                        name="encoding",value = "utf-8"
                )
        },
        urlPatterns = "/*",
        dispatcherTypes = {
                //拦截请求
                DispatcherType.REQUEST,
                DispatcherType.FORWARD,
                DispatcherType.INCLUDE,
                DispatcherType.ERROR
        }
)
public class zhujie implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("zhujie这真是开始");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行请求
            filterChain.doFilter(servletRequest,servletResponse);

            }

}
