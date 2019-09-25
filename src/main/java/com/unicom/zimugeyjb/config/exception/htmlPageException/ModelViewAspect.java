package com.unicom.zimugeyjb.config.exception.htmlPageException;

import com.unicom.zimugeyjb.config.exception.CustomException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 18:50 <br/>
 * @Author: yangjiabin
 */
/**    */

/**  切面拦截  */
@Aspect
@Component
public class ModelViewAspect {


    /**  设置切入点：这里直接拦截别@ModelViewMe注解的方法
     *   拦截有ModelView注解的方法
     * */
    @Pointcut("@annotation(com.unicom.zimugeyjb.config.exception.htmlPageException.ModeViewMe)")
    public void pointcut(){

    }

    /**  当有 ModeViewMe的注解的方法抛出异常的时候，做如下处理
     *   出现异常进行拦截
     * */
    @AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void afterThrowable(Throwable e){
        if(e instanceof CustomException){
            /**    拦截了就行转换customExcetption    转换为ModelViewException
             *  */
            throw ModelViewException.transfer((CustomException) e);
        }
    }




}
