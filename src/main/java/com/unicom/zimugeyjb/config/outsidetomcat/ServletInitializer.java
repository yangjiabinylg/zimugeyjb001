package com.unicom.zimugeyjb.config.outsidetomcat;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/24 11:17 <br/>
 * @Author: yangjiabin
 */


import com.unicom.zimugeyjb.ZimugeyjbApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *     不需要加任何注释  自己会调用
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        //此处的Application。class为带有@SpringBootApplication注解的启动类
        return builder.sources(ZimugeyjbApplication.class);
    }
}
