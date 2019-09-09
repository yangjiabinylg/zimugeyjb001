package com.unicom.zimugeyjb.model;

import lombok.Data;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/9 13:51 <br/>
 * @Author: yangjiabin
 */
@Data
public class Reader {

    private String name;

    private Integer age;


    /**
     {
        "id":1,
        "author":"yangjiabin",
        "title":"我是标题",
        "content":"我是内容",
        "createTime":"",
        "reader":[
                     {
                        "name":"zhangsan",
                        "age":18
                     },
                     {
                     "name":"lisi",
                     "age":28
                     }
                ]
     }
     */

}
