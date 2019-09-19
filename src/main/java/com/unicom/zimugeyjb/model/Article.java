package com.unicom.zimugeyjb.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/6 17:08 <br/>
 * @Author: yangjiabin
 */

@Document(collection = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//默认是字段定义的顺序返回  这里可以重新定义返回的顺序
@JsonPropertyOrder(value = { "content","title"})
public class Article implements Serializable {

    private static final long serialVersionUID = -897656388778833884L;



    //@Id  mongodb有自己的自增id不要自己定义主键
    //序列化反序列化忽略这个字段
    //@JsonIgnore
    private String id;

    //取一个别名  序列化和反序列化都用别名
    //@JsonProperty("writer")
    @Indexed(unique = true)//唯一索引  索引快一点
    private String author;

    private String title;

    private String content;

    //当不会null时才有这个字段
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //直接 发送日期字符串时无法接收的  但是每个日期都加太麻烦了  统一在配置文件配置
    //@JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss" ,timezone = "GMT+8")
    @CreatedDate//按照执行时间初始化数据
    private Date createTime;

    private List<Reader> reader;

}
