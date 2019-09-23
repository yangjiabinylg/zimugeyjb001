package com.unicom.zimugeyjb.customlistener;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:24 <br/>
 * @Author: yangjiabin
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *    2.监听那个事件
 */
@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // todo  发送邮件代码
        log.info(String.format("%s  监听到的事件源:  %s",MyListener2.class.getName(),myEvent.getSource()));
    }
}
