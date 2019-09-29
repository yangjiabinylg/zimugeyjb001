package com.unicom.zimugeyjb.asynctask;

import com.unicom.zimugeyjb.asynctask2.AsyncTask;
import com.unicom.zimugeyjb.asynctask3.AsyncCallBackTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setOut;
import static java.lang.Thread.sleep;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 15:23 <br/>
 * @Author: yangjiabin
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
//    @Autowired
//    private SyncTask syncTask;
//
//    @Test
//    public void testSyncTasks() throws  Exception{
//        syncTask.doTaskOne();
//        syncTask.doTaskTwo();
//        syncTask.doTaskThree();
//    }
///**
// 开始做任务一     Thread[main,5,main]
// 完成任务一，耗时：1947毫秒     Thread[main,5,main]
// 开始做任务二     Thread[main,5,main]
// 完成任务二，耗时：944毫秒    Thread[main,5,main]
// 开始做任务三     Thread[main,5,main]
// 完成任务三，耗时：360毫秒     Thread[main,5,main]
//
// 是顺序执行的  同步任务只有一个线程
//
// */
//
//
//
//
//
//@Autowired
//private AsyncTask asyncTask;
//
//    @Test
//    public void testAsyncTasks() throws  Exception{
//        asyncTask.doTaskOne();
//        asyncTask.doTaskTwo();
//        asyncTask.doTaskThree();
//    }
///**
// 开始做任务二     Thread[main,5,main]
// 开始做任务一     Thread[SimpleAsyncTaskExecutor-1,5,main]
// 完成任务一，耗时：2427毫秒     Thread[SimpleAsyncTaskExecutor-1,5,main]
// 完成任务二，耗时：2960毫秒    Thread[main,5,main]
// 开始做任务三     Thread[main,5,main]
// 完成任务三，耗时：505毫秒     Thread[main,5,main]
//
//  异步任务比同步任务要快
//  为什么？？   和视频不一样
// 视频上没有时间输出（主线程执行完了 三个任务还没执行完  所以无时间输出）
// 但是我为什么有输出？？
//
//
// */




    @Autowired
    private AsyncCallBackTask asyncCallBackTask;

    @Test
    public void testAsyncCallBackTask() throws  Exception{
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();


        // 三个任务都调用完成  退出循环等待
        while (!task1.isDone()||!task2.isDone()||!task3.isDone()){
            sleep(1000);
        }

        long end = currentTimeMillis();
        System.out.println("全部任务完成，总耗时  "+(end - start)+"  毫秒");



    }
/**
 开始做任务一     Thread[SimpleAsyncTaskExecutor-1,5,main]
 开始做任务二     Thread[SimpleAsyncTaskExecutor-2,5,main]
 开始做任务三     Thread[SimpleAsyncTaskExecutor-3,5,main]
 完成任务一，耗时：11349毫秒     Thread[SimpleAsyncTaskExecutor-1,5,main]
 完成任务二，耗时：20969毫秒    Thread[SimpleAsyncTaskExecutor-2,5,main]
 完成任务三，耗时：78943毫秒     Thread[SimpleAsyncTaskExecutor-3,5,main]
 全部任务完成，总耗时  79057  毫秒


 运行一下  总耗时79秒  比串行109秒要快


 总结一下异步任务
 1.@componet让spring的到这个bean
 2.方法上加上@Async注解
 3.主程序不需要回调void返回就好了
 4.主程序要回调就future<string>
 主程序拿到返回值再继续做事情


 */

}
