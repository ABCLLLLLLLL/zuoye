package cn.lzy.configbean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    @Value("${student.id}")
    private int id;
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private int age;



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ",name=" + name + '\'' +
                ",age=" + age +
                '}';


        }
    }

