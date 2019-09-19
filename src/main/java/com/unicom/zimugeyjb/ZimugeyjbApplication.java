package com.unicom.zimugeyjb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ZimugeyjbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZimugeyjbApplication.class, args);
    }

}
