package com.unicom.zimugeyjb.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:52 <br/>
 * @Author: yangjiabin
 */
@Slf4j
@Component
public class CommandLineStarupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineStarupRunner传入参数：{}   ", Arrays.toString(args));
    }
    //AppStartupRunner会帮我们封装成对象   CommandLineStarupRunner需要自己去解析string
}
