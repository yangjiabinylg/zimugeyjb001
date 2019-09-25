package com.unicom.zimugeyjb.config.exception;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 15:06 <br/>
 * @Author: yangjiabin
 */
public class CustomException extends RuntimeException {

    //异常错误编码
    private int code;

    //异常信息
    private String message;


    //私有化构造函数 让你无法调用   只能调用下面的有参构造函数
    private CustomException() {
    }

    /**
     *
     * @param customExcepionType   code:是错误编码（resutful风格）     message：是错误描述 是给程序员看的
     * @param message    这个message是给用户看的信息
     */
    public CustomException(CustomExceptionType customExcepionType , String message){
        this.code = customExcepionType.getCode();
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
