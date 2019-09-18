package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.dao.ArticleMapper;
import com.unicom.zimugeyjb.model.ArticleVo;
import com.unicom.zimugeyjb.pojo.Article;
import com.unicom.zimugeyjb.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/18 14:48 <br/>
 * @Author: yangjiabin
 */
@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;


    @Override
    public ArticleVo saveArticle(ArticleVo articleVo) {
        Article article = dozerMapper.map(articleVo,Article.class);
        articleMapper.insert(article);
        return articleVo;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVo articleVo) {
        Article article = dozerMapper.map(articleVo, Article.class);
        articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public ArticleVo getArticle(Long id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return dozerMapper.map(article,ArticleVo.class);
    }

    @Override
    public List<ArticleVo> getAll() {
        List<Article> articleList = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articleList,ArticleVo.class);
    }
}
