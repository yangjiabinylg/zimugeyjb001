package com.unicom.zimugeyjb;

import com.unicom.zimugeyjb.customlistener.otherMethod.MyListener1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
/*mapper扫描的路径   mybatis*/
@MapperScan(basePackages = {"com.unicom.zimugeyjb.dao"})
@ServletComponentScan
public class ZimugeyjbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZimugeyjbApplication.class, args);
        //不推荐这种方法
        context.addApplicationListener(new MyListener1());
    }

}
