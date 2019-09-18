package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.model.ArticleVo;

import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/18 14:41 <br/>
 * @Author: yangjiabin
 */
public interface ArticleRestService {

    ArticleVo saveArticle(ArticleVo articleVo);

    void deleteArticle(Long id);

    void updateArticle(ArticleVo articleVo);

    ArticleVo getArticle(Long id);

    List<ArticleVo> getAll();
}
