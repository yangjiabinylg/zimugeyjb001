package com.unicom.zimugeyjb.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 15:26 <br/>
 * @Author: yangjiabin
 */
//这4个是lambok注释
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false ,length = 32)
    private String author;

    @Column(nullable = false,unique = true,length = 32)
    private String title;

    @Column(length = 512)
    private String content;


    private Date createTime;


}
