package cn.lzy.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ChapterController {
    private String TAG = "ChapterController";

    @RequestMapping(value = "/hello")
    public String saHello() {
        System.out.println(TAG + "--返回的数据--");
        return "hello Springboot 晚上好";
    }
}









