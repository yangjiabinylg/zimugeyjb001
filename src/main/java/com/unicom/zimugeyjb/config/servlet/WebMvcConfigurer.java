package com.unicom.zimugeyjb.config.servlet;

import com.unicom.zimugeyjb.config.servlet.CustomHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:05 <br/>
 * @Author: yangjiabin
 */

////针对Servlet方法执行前后加一些处理代码   主要针对的是老项目
// 光写这个拦截器不行  还要告诉springboot我们实现了那个拦截器
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器  拦截规则
        //多个拦截器时  依次添加 执行顺序添加顺序    可以写多个拦截器
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
    }


    public static HandlerInterceptor getHandlerInterceptor(){
        //刚才写的拦截器注册一下
        return new CustomHandlerInterceptor();
    }
}
