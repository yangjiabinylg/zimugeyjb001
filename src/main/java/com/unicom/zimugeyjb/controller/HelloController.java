package com.unicom.zimugeyjb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/6 16:54 <br/>
 * @Author: yangjiabin
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello  world";
    }



}
