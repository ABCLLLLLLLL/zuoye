package cn.lzy.Web.mvc;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(uri.startsWith("/admin")||(uri.startsWith("/shang") && null == loginUser)) {
            response.sendRedirect("/toLoginPage1");
            return false;
    }
        return true;
}
@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response,
                       Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    request.setAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, @Nullable Exception ex) throws Exception {
    }
