package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.dao.ArticleMapper;
import com.unicom.zimugeyjb.model.ArticleVo;
import com.unicom.zimugeyjb.pojo.Article;
import com.unicom.zimugeyjb.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @CachePut(value = "article",key = "#articleVo.getId()")
    public ArticleVo saveArticle(ArticleVo articleVo) {
        Article article = dozerMapper.map(articleVo,Article.class);
        articleMapper.insert(article);

        //todo 把readers存储到数据库里面
        articleVo.setId(article.getId());
        return articleVo;
    }

    @Override
    @CacheEvict(value = "article",key = "#id")
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = "article",key = "#articleVo.getId()")
    public ArticleVo updateArticle(ArticleVo articleVo) {
        Article article = dozerMapper.map(articleVo, Article.class);
        articleMapper.updateByPrimaryKey(article);
        return articleVo;
    }


    //@Cacheable(value = "article")
    @Override
    @Cacheable(value = "article",key="#id",condition = "#id > 1")
    //@Cacheable(value = "article")
    public ArticleVo getArticle(Long id) {
        // todo 把读者信息查询出来复制给ArticleVo
        Article article = articleMapper.selectByPrimaryKey(id);
        return dozerMapper.map(article,ArticleVo.class);
    }

    @Cacheable(value = "articleAll")
    @Override
    public List<ArticleVo> getAll() {
        List<Article> articleList = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articleList,ArticleVo.class);
    }
}
