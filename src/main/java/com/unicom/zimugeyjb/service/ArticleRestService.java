package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.model.ArticleVo;
import com.unicom.zimugeyjb.pojo.Article;

import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 15:36 <br/>
 * @Author: yangjiabin
 */
public interface ArticleRestService {

    ArticleVo saveArticle(ArticleVo articleVo);

    void deleteArticle(Long id);

    void updateArticle(ArticleVo articleVo);

    ArticleVo getArticle(Long id);

    List<ArticleVo> getAll();


}
