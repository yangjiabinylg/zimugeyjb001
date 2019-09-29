package com.unicom.zimugeyjb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
/**mapper扫描的路径   mybatis*/
@MapperScan(basePackages = {"com.unicom.zimugeyjb.dao"})
/**    启动类开启异步任务   默认是不开启的   */
@EnableAsync
public class ZimugeyjbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZimugeyjbApplication.class, args);
    }

}
