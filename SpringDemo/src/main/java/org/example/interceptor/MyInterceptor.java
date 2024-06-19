package org.example.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Project: HelloController.java
 * @Package: org.example.interceptor
 * @Description: 拦截器
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年06月19日 11:00
 */

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception {
        //对于请求/admin路径时，判断用户是否登录
        String uri=request.getRequestURI();
        Object loginUser=request.getSession().getAttribute("loginUser");
        if(uri.startsWith("/admin") && loginUser==null){
            response.sendRedirect("/toLoginPage");
            System.out.println("HandlerItTwo preHandle...");
            return false;
        }else
        {
            return true;
        }
    }

    @Override
    public  void  postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{
        request.setAttribute("myname","张三");
        System.out.println("HandlerItTwo postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, @Nullable Exception ex) throws Exception {
    }

}