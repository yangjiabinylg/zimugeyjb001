package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.dao.ArticleJDBCDao;
import com.unicom.zimugeyjb.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/16 19:36 <br/>
 * @Author: yangjiabin
 */
@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    ArticleJDBCDao articleJDBCDao;


    @Transactional
    @Override
    public Article saveArticle(Article article) {

        articleJDBCDao.save(article);

        return article;
    }

    @Override
    public void deleteArticle(Long id) {

        articleJDBCDao.deleteById(id);
    }

    @Override
    public void updateAriticle(Article article) {
        articleJDBCDao.updateById(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDao.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDao.findAll();
    }
}
