package com.unicom.zimugeyjb.asynctask2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 15:29 <br/>
 * @Author: yangjiabin
 */

@Component
public class AsyncTask extends AbstractTask {
/**
 *
 */

    /**
     *        异步任务
     */


    /**
     *       @Async   异步任务注释
     */
     @Async
     @Override
    public void doTaskOne() throws Exception {
         /**
          *   调用的还是父类的方法
          */
        super.doTaskOne();

    }

    @Override
    public void doTaskTwo() throws Exception {
        /**
         *     调用的还是父类的方法
         */
        super.doTaskTwo();
    }

    @Override
    public void doTaskThree() throws Exception {
        /**
         *   调用的还是父类的方法
         */
        super.doTaskThree();
    }


    /**
     *        这是重点    如何异步任务
     */
}
