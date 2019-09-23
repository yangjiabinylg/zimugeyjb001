package com.unicom.zimugeyjb.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:54 <br/>
 * @Author: yangjiabin
 */

@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(" AppStartupRunner参数名称：{}  ",args.getOptionNames());
        log.info(" AppStartupRunner参数：{}  ",args.getSourceArgs());
    }

    //AppStartupRunner会帮我们封装成对象   CommandLineStarupRunner需要自己去解析string
}
