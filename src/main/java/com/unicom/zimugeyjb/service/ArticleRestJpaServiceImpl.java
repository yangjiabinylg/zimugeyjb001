package com.unicom.zimugeyjb.service;

import com.unicom.zimugeyjb.jpadao.testdbjpa.ArticleRepository;
import com.unicom.zimugeyjb.jpadao.testdbjpa2.MessageRepository;
import com.unicom.zimugeyjb.model.ArticleVo;
import com.unicom.zimugeyjb.pojo.Article;
import com.unicom.zimugeyjb.pojo.Message;
import com.unicom.zimugeyjb.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebResult;
import java.util.List;
import java.util.Optional;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 15:39 <br/>
 * @Author: yangjiabin
 */
@Slf4j
@Service
public class ArticleRestJpaServiceImpl implements ArticleRestService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVo saveArticle(ArticleVo articleVo) {

        Article article = dozerMapper.map(articleVo, Article.class);
        articleRepository.save(article);


        Message  message = new Message();
        message.setName("张三");
        message.setContent("内容");
        messageRepository.save(message);

        return articleVo;
    }

    @Override
    public void deleteArticle(Long id) {
            articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVo articleVo) {
        Article article = dozerMapper.map(articleVo, Article.class);
        articleRepository.save(article);
    }

    @Override
    public ArticleVo getArticle(Long id) {

        Optional<Article> article = articleRepository.findById(id);
        //读者查出来
        ArticleVo articleVo = dozerMapper.map(article.get(), ArticleVo.class);
        //articleVo.setReader(设置读者);
        return articleVo ;
    }

    @Override
    public List<ArticleVo> getAll() {
        List<Article> articleList = articleRepository.findAll();
        return DozerUtils.mapList(articleList,ArticleVo.class);
    }
}
