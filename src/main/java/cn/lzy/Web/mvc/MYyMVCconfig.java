package cn.lzy.Web.mvc;
//
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MYyMVCconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }
}
