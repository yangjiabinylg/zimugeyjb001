package com.unicom.zimugeyjb.config.exception.htmlPageException;

import java.lang.annotation.*;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 18:41 <br/>
 * @Author: yangjiabin
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
/**只能在方法上使用此注解   定义这个  只是定义一个注解没有其他作用 */
@Target({ElementType.METHOD})
public @interface ModeViewMe {

}
