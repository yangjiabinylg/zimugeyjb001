package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.dao.ArticleJDBCDao;
import com.unicom.zimugeyjb.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;


    @Transactional
    @Override
    public Article saveArticle(Article article) {

        //出现了异常   只有第一个会回滚事务    第二个是不会回滚事务的
        articleJDBCDao.save(article,primaryJdbcTemplate);

        articleJDBCDao.save(article,secondaryJdbcTemplate);

        //int a = 2/0;

        return article;
    }

    @Override
    public void deleteArticle(Long id) {

        articleJDBCDao.deleteById(id,primaryJdbcTemplate);
    }

    @Override
    public void updateAriticle(Article article) {
        articleJDBCDao.updateById(article,primaryJdbcTemplate);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDao.findById(id,primaryJdbcTemplate);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDao.findAll(primaryJdbcTemplate);
    }
}
