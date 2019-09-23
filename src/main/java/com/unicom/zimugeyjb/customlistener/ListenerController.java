package com.unicom.zimugeyjb.customlistener;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:29 <br/>
 * @Author: yangjiabin
 */
@RestController
public class ListenerController {

    @Resource
    ConfigurableApplicationContext applicationContext;

    @RequestMapping("/publish")
    public String hello(){
        //todo 业务处理  1.做业务

        //2.新建进程发邮件
        applicationContext.publishEvent(new MyEvent("邮件内容"));

        //3.响应客户端
        return "ok";

    }


}
