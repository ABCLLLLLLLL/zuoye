package cn.lzy.profielconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
@Profile("test")
public class TestDBConnector implements DBConnector{
    @Override
    public String config() {
        return "这个是开发环境！";
    }
}
