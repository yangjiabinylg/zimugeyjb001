package com.unicom.zimugeyjb.config.accesslog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/27 14:28 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    /**
     *    注册拦截器别忘了
     */

    /**
     *    设置排除路径，spring boot 2.* ，注意排除掉静态的路径，
     *    不然静态资源无法访问
     */
    private final String [] excludePath = {"/static"};


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLogInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
    }
}
