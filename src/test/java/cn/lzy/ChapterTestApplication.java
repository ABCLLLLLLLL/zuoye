package cn.lzy;

import cn.lzy.configbean.Person;
import cn.lzy.configbean.Student;
import cn.lzy.configbean.User;
import cn.lzy.controller.ChapterController;
import cn.lzy.profielconfig.DBConnector;
import org.hibernate.validator.constraints.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTestApplication {
    private String TAG = "ChapterTestApplication";

    @Autowired
    ChapterController ChapterController;

    @Autowired
    Student student;

    @Autowired
    User user;
    @Autowired
    Person person;

//    @Autowired
//    DBConnector dbConnector;

    @Test
    public void getHello() {
  /*      System.out.println( "----单元测试返回的数据11111111---------" + ChapterController.saHello());*/
//     /*   System.out.println("单元测试返回===="+student);*/
//        System.out.println(user);
//
//        System.out.println("单元测试返回的person数据---"+person);
//
//        System.out.println(dbConnector.config());
        System.out.println(student);


    }

}
