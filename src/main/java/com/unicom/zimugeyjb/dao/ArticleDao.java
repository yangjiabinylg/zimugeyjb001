package com.unicom.zimugeyjb.dao;

import com.unicom.zimugeyjb.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/19 15:31 <br/>
 * @Author: yangjiabin
 */
public interface ArticleDao extends MongoRepository<Article,String> {


    //支持关键字查询，和JPA的用法一样
    Article findByAuthor(String author);
}
