package com.unicom.zimugeyjb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/26 19:44 <br/>
 * @Author: yangjiabin
 */

@RestController
@Slf4j
public class LogDemoController {


    @GetMapping("/logdemo")
    public String log(){
        log.trace("==============trace");
        log.debug("==============debug");
        log.info("==============info");
        log.warn("==============warn");
        log.error("==============error");
        return "logok";
    }

}
