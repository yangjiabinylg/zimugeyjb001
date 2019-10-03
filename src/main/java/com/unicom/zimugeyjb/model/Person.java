package com.unicom.zimugeyjb.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/10/3 19:44 <br/>
 * @Author: yangjiabin
 */
@Data
public class Person implements Serializable {


    private static final long serialVersionUID = 4264551646588848391L;

    String id;

    String firstName;

    String lastName;

    Address address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
