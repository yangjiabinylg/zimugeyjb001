package com.unicom.zimugeyjb.asynctask3;

import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 15:09 <br/>
 * @Author: yangjiabin
 */
public abstract class AbstractTask {

    private static Random random = new Random();

    public void doTaskOne() throws Exception{
        System.out.println("开始做任务一     "+Thread.currentThread());
        long start = currentTimeMillis();
        sleep(random.nextInt(100000));
        long end = currentTimeMillis();
        System.out.println("完成任务一，耗时："+(end - start) + "毫秒     "+Thread.currentThread());
    }


    public void doTaskTwo() throws Exception{
        System.out.println("开始做任务二     "+Thread.currentThread());
        long start = currentTimeMillis();
        sleep(random.nextInt(100000));
        long end = currentTimeMillis();
        System.out.println("完成任务二，耗时："+(end - start) + "毫秒    "+Thread.currentThread());
    }



    public void doTaskThree() throws Exception{
        System.out.println("开始做任务三     "+Thread.currentThread());
        long start = currentTimeMillis();
        sleep(random.nextInt(100000));
        long end = currentTimeMillis();
        System.out.println("完成任务三，耗时："+(end - start) + "毫秒     "+Thread.currentThread());
    }


}
