package com.unicom.zimugeyjb.config.exception.htmlPageException;

import com.unicom.zimugeyjb.config.exception.CustomException;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 18:26 <br/>
 * @Author: yangjiabin
 */
public class ModelViewException extends RuntimeException {

    //这2个字段和customException是一样的字段
    //异常错误编码
    private int code;

    //异常信息
    private String message;


    public static ModelViewException transfer(CustomException e){
        return new ModelViewException(e.getCode(),e.getMessage());
    }


    private ModelViewException( int code, String message ) {
        this.code = code;
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

