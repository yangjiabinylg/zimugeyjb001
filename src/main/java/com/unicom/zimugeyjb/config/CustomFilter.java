package com.unicom.zimugeyjb.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 16:39 <br/>
 * @Author: yangjiabin
 */
//注册器名为customFilter，拦截的url为所有
//@WebFilter(filterName = "customFilter",urlPatterns = {"/*"})
@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("customFilter 请求处理之前");
        //对request response进行一些预处理
        // 比如设置请求码
        // request.setCharcterEncoding("UTF-8");
        // response.setCharcterEncoding("UTF-8");

        //链路  直接传给下一个过滤器  //没有其他filter的话  就是contorller了
        filterChain.doFilter(servletRequest,servletResponse);


        log.info("customFilter 请求处理之后");
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }

    //监听器和过滤器实际差不多的





}
