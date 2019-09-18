package com.unicom.zimugeyjb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*mapper扫描的路径   mybatis*/
//@MapperScan(basePackages = {"com.unicom.zimugeyjb.dao"})   多数据源只能一个一个@Mapper
public class ZimugeyjbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZimugeyjbApplication.class, args);
    }

}
