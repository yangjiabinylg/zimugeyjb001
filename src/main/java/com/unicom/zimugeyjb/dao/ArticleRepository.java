package com.unicom.zimugeyjb.dao;

import com.unicom.zimugeyjb.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 15:32 <br/>
 * @Author: yangjiabin
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {


    Article findByAuthor(String author);

}
