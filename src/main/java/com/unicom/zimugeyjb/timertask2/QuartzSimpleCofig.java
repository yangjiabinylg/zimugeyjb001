package com.unicom.zimugeyjb.timertask2;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 20:05 <br/>
 * @Author: yangjiabin
 */

@Configuration
public class QuartzSimpleCofig {

    //指定具体的低昂是任务类
    @Bean
    public JobDetail uploadTaskDetail(){
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger uploadTaskTrigger(){
        //这里设定触发执行的方式   每隔5秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");

        //返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(cronScheduleBuilder)
                .build();
    }




}
