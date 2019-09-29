//package com.unicom.zimugeyjb.timertask;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//
///**
// * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
// * @Desc: <br/>
// * @ProjectName: zimugeyjb <br/>
// * @Date: 2019/9/29 19:52 <br/>
// * @Author: yangjiabin
// */
//
//@Configuration
///**    开启定时任务  不放启动类上面了   */
//@EnableScheduling
//public class ScheduleConfig implements SchedulingConfigurer {
//
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.setScheduler(scheduledTaskExecutor());
//    }
//
//    @Bean
//    public Executor scheduledTaskExecutor() {
//        /**   弄个线程池  3个线程  我们就三个任务  */
//        return Executors.newScheduledThreadPool(3);
//    }
//}
