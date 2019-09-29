package com.unicom.zimugeyjb.asynctask3;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 16:44 <br/>
 * @Author: yangjiabin
 */

@Component
public class AsyncCallBackTask extends AbstractTask {


    /**
     *
     *    如何在3个异步任务执行完了  再做一件事呢
     *
     *    如果不用再多任务执行后 再次执行新任务 就返回void
     *    如果执行多任务后还需要执行  新任务    就返回Future获取这个
     *
     *
     */

    /**
     *    Future<String>  每个任务完成独有一个反馈
     */
    @Async
    public Future<String> doTaskOneCallback() throws  Exception{
        super.doTaskOne();
        return new AsyncResult<>("任务一完成");
    }

    /**
     *    Future<String>  每个任务完成独有一个反馈
     */
    @Async
    public Future<String> doTaskTwoCallback() throws  Exception{
        super.doTaskTwo();
        return new AsyncResult<>("任务二完成");
    }

    /**
     *    Future<String>  每个任务完成独有一个反馈
     */
    @Async
    public Future<String> doTaskThreeCallback() throws  Exception{
        super.doTaskThree();
        return new AsyncResult<>("任务三完成");
    }


}
