package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.config.exception.CustomException;
import com.unicom.zimugeyjb.config.exception.CustomExceptionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 16:04 <br/>
 * @Author: yangjiabin
 */
@Service
public class ExceptionService {

    //测试写的异常好不好用  做2个异常试试

    //服务层  模拟系统异常
    public void systemBizError() throws CustomException{
        try{
            Class.forName("com.mysql.jdbc.xxx.com");
        }catch (ClassNotFoundException e){
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"在xxx业务中，myBiz()方法内，出现ClassNotFoundException");
        }
    }


    //服务层  模拟用户输入数据异常
    public List<String> userBizError(int input)throws CustomException{
        //1.发现异常
        if(input < 0 ){
            //模拟业务校验失败
            //2.抛出异常  就2步走
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,"您输入的数据不符合业务逻辑，不能小于0");
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add("比克");
            list.add("詹姆斯");
            list.add("库里");
            return list;
        }
    }


}
