package com.unicom.zimugeyjb.config.accesslog;

import lombok.Data;

import java.util.Date;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/27 9:56 <br/>
 * @Author: yangjiabin
 */
@Data
public class AccessLog {
    /**
     *  这个类记录一些用户的操作日志
     *  记录这些字段
     */

    /**
     *  访问者用户名
     */
    private String username;
    /**
     *  请求路径
     */
    private String url;

    /**
     *  请求消耗时长
     */
    private Integer duration;

    /**
     *  http方法：GET,POST等
     */
    private String httpMethod;

    /**
     *  http 请求响应状态码
     */
    private Integer httpStatus;


    /**
     *   访问者ip
     */
    private String ip;


    /**
     *   此条记录创建时间
     */
    private Date createTime;




}
