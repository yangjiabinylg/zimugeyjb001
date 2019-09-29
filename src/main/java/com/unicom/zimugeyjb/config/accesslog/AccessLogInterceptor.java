package com.unicom.zimugeyjb.config.accesslog;

import com.unicom.zimugeyjb.utils.AdrressIpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/27 10:06 <br/>
 * @Author: yangjiabin
 */
@Slf4j
public class AccessLogInterceptor implements HandlerInterceptor {

    /**
     * 方法1：在controller进来之前进行ip，用户，时间记录，
     * 但是这样不友好，代码耦合度太高，日志模块可以分离出来，独立的写。
     * 方法2：使用我们之前讲的拦截器，
     *
     * */


    /**    开始请求时间标识     */
    private static final String LOGGER_SEND_TIME = "SEND_TIME";
    /**    请求日志实体标识         */
    private static final String LOGGER_ACCESSLOG = "ACCESSLOG_ENTITY";


    /**
     *   进入springMVC的Controller之前开始记录日志实体
     *
     *    进入controller直之前 就记录些信息
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**  创建日志实体         */
        AccessLog accessLog = new AccessLog();
        /**  设置ip地址         */
        accessLog.setIp(AdrressIpUtils.getIpAdrress(request));
        /**   设置请求方法，get，post        */
        accessLog.setHttpMethod(request.getMethod());
        /**   设置请求路径        */
        accessLog.setUrl(request.getRequestURL().toString());
        /**  设置请求开始时间       */
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        /**  设置请求实体到request内，方便afterCompletion方法调用      将以上信息廍   */
        request.setAttribute(LOGGER_ACCESSLOG,accessLog);

        return true;
    }

    /**
     *
     进入controller之后 就记录些信息
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /**  获取本次请求日志实体   取出来request里面的信息      */
        AccessLog accessLog = (AccessLog) request.getAttribute(LOGGER_ACCESSLOG);
        /**  获取请求错误码，根据需求存入数据库，这里不保存         */
        int status = response.getStatus();
        accessLog.setHttpStatus(status);
        /**  获取username的方法很多这里举个例子 存放在session怎么取出来
         *    request.getSession().getAttribute("username");
         * */
        accessLog.setHttpStatus(status);
        /**    设置访问者（这里暂时写死）
         *     因为不同的应用可能将username,放在session中或者放在request中
         *     总之可以获取到，但是方法不同    这里暂时写死
         * */
        accessLog.setUsername("admin");
        /**   当前时间      */
        long currentTime = System.currentTimeMillis();
        /**   请求开始时间     */
        long sendTime = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        /**   设置请求时间差  记录总时间    */
        accessLog.setDuration(Long.valueOf(currentTime - sendTime).intValue());

        accessLog.setCreateTime(new Date());
        /**  将sysLog对象持久化保存         */
        log.info(accessLog.toString());

    }


    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */
    /**         */



}
