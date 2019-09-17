package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.model.Article;

import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/16 19:26 <br/>
 * @Author: yangjiabin
 */
public interface ArticleRestService {

    Article saveArticle(Article article);

    void deleteArticle(Long id);

    void updateAriticle(Article article);

    Article getArticle(Long id);

    List<Article>  getAll();
}
