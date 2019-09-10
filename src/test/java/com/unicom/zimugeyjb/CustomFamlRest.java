package com.unicom.zimugeyjb;

import com.unicom.zimugeyjb.model.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/10 15:36 <br/>
 * @Author: yangjiabin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomFamlRest {

    @Autowired
    Family family;


    @Test
    public void hello(){
        System.out.println(family.toString());
    }



}
