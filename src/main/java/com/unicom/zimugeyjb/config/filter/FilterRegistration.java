package com.unicom.zimugeyjb.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 16:57 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方法进行实体类过滤器，这样不可以自动注入过滤器使用其他bean类
        //当然，若无其他bean需要获取时，可直接new Customer(),也可以使用getBean的方法
        registrationBean.setFilter(customFilter());
        //过滤器名称
        registrationBean.setName("customFilter");
        //拦截路径
        registrationBean.addUrlPatterns("/*");
        //设置顺序
        registrationBean.setOrder(10);
        return registrationBean;

    }

    @Bean
    public Filter customFilter(){
        return new CustomFilter();
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方法进行实体类过滤器，这样不可以自动注入过滤器使用其他bean类
        //当然，若无其他bean需要获取时，可直接new Customer(),也可以使用getBean的方法
        registrationBean.setFilter(customFilter2());
        //过滤器名称
        registrationBean.setName("customFilter2");
        //拦截路径
        registrationBean.addUrlPatterns("/*");
        //设置顺序
        registrationBean.setOrder(11);
        return registrationBean;

    }

    @Bean
    public Filter customFilter2(){
        return new CustomFilter2();
    }


}
