package com.unicom.zimugeyjb.asynctask4;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 19:19 <br/>
 * @Author: yangjiabin
 */


@Component
public class AsyncCallBackTask  extends AbstractTask{

    @Async("taskExecutor")
    public Future<String> doTaskOneCallBack() throws Exception{
        super.doTaskOne();
        System.out.println("任务一，当前线程："+Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }


    @Async("taskExecutor")
    public Future<String> doTaskTwoCallBack() throws Exception{
        super.doTaskTwo();
        System.out.println("任务二，当前线程："+Thread.currentThread().getName());
        return new AsyncResult<>("任务二完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskThreeCallBack() throws Exception{
        super.doTaskThree();
        System.out.println("任务三，当前线程："+Thread.currentThread().getName());
        return new AsyncResult<>("任务三完成");
    }
}
