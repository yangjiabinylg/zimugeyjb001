package com.unicom.zimugeyjb.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:58 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class BeanRunner {

    //有时候要指定CommandLine 执行顺序  A执行完才能执行B

    @Bean
    @Order(1)
    public CommandLineRunner runner1(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("CommandLineRunner runner1() "+ Arrays.toString(args));
            }
        };
    }


    @Bean
    @Order(2)
    public CommandLineRunner runner2(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("CommandLineRunner runner2() "+ Arrays.toString(args));
            }
        };
    }


    @Bean
    @Order(3)
    public CommandLineRunner runner3(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("CommandLineRunner runner3() "+ Arrays.toString(args));
            }
        };
    }
}
