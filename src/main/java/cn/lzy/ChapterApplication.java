package cn.lzy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

/*@SpringBootApplication
//@ImportResource("classpath:xmlproperties.xml")
public class ChapterApplication {
    public static void main(String[]args){
        SpringApplication.run(ChapterApplication.class,args);

    }*/

@SpringBootApplication
@EnableCaching//开启Spring Boot基于注解的缓存管理支持
@ServletComponentScan

public class ChapterApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ChapterApplication.class);
    }
}


