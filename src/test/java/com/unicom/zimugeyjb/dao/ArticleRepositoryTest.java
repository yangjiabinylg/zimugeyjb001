package com.unicom.zimugeyjb.dao;

import com.unicom.zimugeyjb.pojo.Article;
import com.unicom.zimugeyjb.service.ArticleRestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 15:58 <br/>
 * @Author: yangjiabin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void findByAuthor() {
        Article article = articleRepository.findByAuthor("yangjiabin");
        System.out.println(article);
    }
}