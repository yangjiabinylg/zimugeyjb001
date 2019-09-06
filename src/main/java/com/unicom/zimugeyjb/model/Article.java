package com.unicom.zimugeyjb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/6 17:08 <br/>
 * @Author: yangjiabin
 */

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Article {


    private Long id;

    private String author;


}
