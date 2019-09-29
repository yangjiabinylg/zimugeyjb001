package com.unicom.zimugeyjb.asynctask4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 18:33 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class TaskConfiguration {
    /**
     *    线程池来管理线程   不让线程无限新建
     *
     *
     *    线程池是java的  不是springboot的
     */
    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor  executor = new ThreadPoolTaskExecutor();
        /**    线程池大小   */
        executor.setCorePoolSize(10);
        /**    最大线程池    */
        executor.setMaxPoolSize(20);
        /**    队列大小    */
        executor.setQueueCapacity(200);
        /**    存活时间    */
        executor.setKeepAliveSeconds(60);
        /**    线程池名字    */
        executor.setThreadNamePrefix("taskExecutor---");
        /**    看里面有没有任务有就等等  优雅点     */
        executor.setWaitForTasksToCompleteOnShutdown(true);
        /**    最多等60秒  还没好就只能关闭了    */
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /**    */
        return executor;
    }

}
