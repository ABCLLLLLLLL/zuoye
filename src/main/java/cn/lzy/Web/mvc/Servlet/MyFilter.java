package cn.lzy.Web.mvc.Servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = {"/antionLogin","/antionMyFilter"})
//@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     //   Filter.super.init(filterConfig);
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        Filter.super.destroy();
    }
}
