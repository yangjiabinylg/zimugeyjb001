package com.unicom.zimugeyjb.model;

import lombok.Data;

import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/10 15:27 <br/>
 * @Author: yangjiabin
 */
@Data
public class Child {

    private String name;

    private Integer age;


    private List<Friend> friends;

}
