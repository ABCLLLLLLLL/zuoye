package cn.lzy.configbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private int id;
    private String name;
    private int age;
    private String[] hobby;
    private List electProduct;
    private Map friends;
    private Course course;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setElectProduct(List electProduct) {
        this.electProduct = electProduct;
    }

    public void setFriends(Map friends) {
        this.friends = friends;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", electProduct=" + electProduct +
                ", friends=" + friends +
                ", course=" + course +
                '}';
    }
}
