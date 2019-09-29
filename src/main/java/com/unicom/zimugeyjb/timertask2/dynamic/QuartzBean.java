package com.unicom.zimugeyjb.timertask2.dynamic;

import lombok.Data;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/29 20:19 <br/>
 * @Author: yangjiabin
 */
@Data
public class QuartzBean {

    /**  任务id  */
    private String id;

    /**   任务名称  */
    private String jobName;

    /**  任务执行类  */
    private String jobClass;

    /**  任务状态   启动还是暂停  */
    private Integer status;

    /**  任务运行时间表达式  */
    private String cronExpression;

    /**   */


    /**   */




}
