package cn.lzy.customconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    ("myProperties1")
    public MyProperties getMyProperties(){
        return  new MyProperties();
    }
}
