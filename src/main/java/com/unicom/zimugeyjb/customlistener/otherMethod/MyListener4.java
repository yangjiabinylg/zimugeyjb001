package com.unicom.zimugeyjb.customlistener.otherMethod;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:24 <br/>
 * @Author: yangjiabin
 */

import com.unicom.zimugeyjb.customlistener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *    2.监听那个事件
 */
@Component //     listen1没有这个注解   没有继承接口 事件季节参数传递   不推荐这种方法
@Slf4j
public class MyListener4  {

    @EventListener
    public void onApplicationEvent(MyEvent myEvent) {
        // todo  发送邮件代码
        log.info(String.format("%s  监听到的事件源:  %s", MyListener4.class.getName(),myEvent.getSource()));
    }
}
