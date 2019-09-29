//package com.unicom.zimugeyjb.timertask;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
// * @Desc: <br/>
// * @ProjectName: zimugeyjb <br/>
// * @Date: 2019/9/29 19:41 <br/>
// * @Author: yangjiabin
// */
//@Component
//public class ScheduledJobs {
//
//    /**    表示方法执行完成后5秒在开始执行  任务1可能没有执行完  就开始执行任务2了  */
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException{
//        System.out.println("fixedDelay 开始:"+new Date() +Thread.currentThread());
//        Thread.sleep(3*1000);
//        System.out.println("fixedDelay 结束："+new Date() +Thread.currentThread());
//    }
//
//
//    /**    每隔3秒执行    任务1一定执行完  才开始执行任务2了  */
//    @Scheduled(fixedRate = 5000)
//    public void fixedRateJob() throws InterruptedException{
//        System.out.println("fixedRate 开始:"+new Date() +Thread.currentThread());
//        Thread.sleep(6*1000);
//        System.out.println("fixedRate 结束："+new Date() +Thread.currentThread());
//    }
//
//
//    /**    表示每隔10秒执行一次    */
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void cronJob() throws InterruptedException{
//
//        System.out.println("======= cron："+new Date() +Thread.currentThread());
//    }
//
//
//
//
//
//
//
//}
