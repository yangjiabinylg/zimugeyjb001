package com.unicom.zimugeyjb.config.exception;

import com.unicom.zimugeyjb.model.AjaxResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 15:53 <br/>
 * @Author: yangjiabin
 */

//全局异常处理类用这个注解@ContollerAdvice
@ControllerAdvice
public class WebExceptionHandler {


    /**
       这个方法和下面的方法是为了 校验用户输入出错时调用的异常
       这个能捕获的异常小   下面的方法可以捕获更大的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handleBindException(MethodArgumentNotValidException e){
        //获取校验的message字段信息  加注解时写的信息
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,fieldError.getDefaultMessage()));
    }

    /**
         这个方法和上面的方法是为了 校验用户输入出错时调用的异常
         这个能捕获的异常大   上面的方法可以捕获小
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handleBindException(BindException e){
        //获取校验的message字段信息  加注解时写的信息
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,fieldError.getDefaultMessage()));
    }




    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException(CustomException e){
        if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以了
            //todo 将500异常持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e){
        //todo 将异常持久化处理，方便运维人员处理

        //没有被程序员发现，并转换为CustomException的异常，
        //都是其他已成或者未知异常
        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR,"未知异常"));
    }





}
