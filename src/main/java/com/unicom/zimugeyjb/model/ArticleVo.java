package com.unicom.zimugeyjb.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/6 17:08 <br/>
 * @Author: yangjiabin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//默认是字段定义的顺序返回  这里可以重新定义返回的顺序
@JsonPropertyOrder(value = { "content","title"})
public class ArticleVo {


    //序列化反序列化忽略这个字段
    //@JsonIgnore
    private Long id;

    //取一个别名  序列化和反序列化都用别名
    //@JsonProperty("writer")
    private String author;

    private String title;

    private String content;

    //当不会null时才有这个字段
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //直接 发送日期字符串时无法接收的  但是每个日期都加太麻烦了  统一在配置文件配置
    //@JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;

    private List<Reader> reader;

}
