package com.unicom.zimugeyjb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/10/4 17:45 <br/>
 * @Author: yangjiabin
 */
@RestController
public class RedisSesionController {

    @RequestMapping(value = "/uid",method = RequestMethod.GET)
    public @ResponseBody
    String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");

        if(uid == null ){
            uid  = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);

        return session.getId();
    }




}
