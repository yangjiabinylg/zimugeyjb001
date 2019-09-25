package com.unicom.zimugeyjb.config.exception;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 15:02 <br/>
 * @Author: yangjiabin
 */
public enum CustomExceptionType {

    USER_INPUT_ERROR(400,"用户输入错误"),
    SYSTEM_ERROR(500,"系统服务异常"),
    OTHER_ERROR(990,"其他未知异常");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    private int code;//code;

    private String typeDesc;//异常类型中文描述

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }
}
