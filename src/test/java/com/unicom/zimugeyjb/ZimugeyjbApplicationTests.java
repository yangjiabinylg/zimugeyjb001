package com.unicom.zimugeyjb;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.zimugeyjb.dao.ArticleMapper;
import com.unicom.zimugeyjb.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZimugeyjbApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    ArticleMapper articleMapper;


    @Test
    public void testPageHelper() {

        Article article = articleMapper.selectByPrimaryKey(4L);

        //只有紧跟在 PageHelper.startPage 方法后面的第一个Mybatis的查询会被分页
        PageHelper.startPage(1,3);
        List<Article> articleList = articleMapper.selectByExample(null);
        PageInfo<Article> page = PageInfo.of(articleList);
        System.out.println(page);

    }


}
