package com.unicom.zimugeyjb.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/10/3 19:46 <br/>
 * @Author: yangjiabin
 */

@Data
public class Address implements Serializable {

    private static final long serialVersionUID = -5123805202812649662L;

    String city;

    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
