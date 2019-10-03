package com.unicom.zimugeyjb.model;

import com.unicom.zimugeyjb.config.exception.CustomException;
import com.unicom.zimugeyjb.config.exception.CustomExceptionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/9 14:13 <br/>
 * @Author: yangjiabin
 */
@Data
@ApiModel//统一返回类型描述
public class AjaxResponse implements Serializable {

    private static final long serialVersionUID = 5303524676787468527L;


    @ApiModelProperty("是否请求成功")
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    private AjaxResponse() {
    }

    //请求出现异常时的响应数据封装
    public static AjaxResponse error(CustomException e){

        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        //用户输入错误
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }
        //系统内部错误
        else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage()+"，系统异常，请联系管理员：1375812****");
        }
        //未知错误
        else{
            resultBean.setMessage("未知异常");
        }
        return resultBean;
    }



    public static AjaxResponse success(){
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("success");
        return response;
    }


    public static AjaxResponse success(Object data){
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("success");
        response.setData(data);
        return response;

    }
}
