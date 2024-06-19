package org.example.config;

import org.example.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Project: SpringDemo
 * @Package: org.example.config
 * @Description: WebMvcConfigurer接口配置类
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月10日 11:32
 */


@Configuration
public class MyMVCconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //请求toLoginPage和login.html映射路径自动跳转到login.html视图
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");

    }

    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").
                excludePathPatterns("/login.html");
    }


}
