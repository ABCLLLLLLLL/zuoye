package cn.lzy.Web.mvc.Servlet;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("contextInitiaized...");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("contextDestroyed...");
    }
}
