package com.unicom.zimugeyjb.customlistener;

import org.springframework.context.ApplicationEvent;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 19:22 <br/>
 * @Author: yangjiabin
 */

/**
 *     1.第一步自定义事件  继承ApplicationEvent
 */
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
