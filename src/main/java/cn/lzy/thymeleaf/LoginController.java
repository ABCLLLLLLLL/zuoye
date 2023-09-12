package cn.lzy.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Controller
public class LoginController {
   @GetMapping("/toLoginPage")//返回数据格式：JSON;访问方式
   public String toLoginPage(Model model){
      model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
       return "login";//指向login.html文件
  }

}