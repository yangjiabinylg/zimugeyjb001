package com.unicom.zimugeyjb.dao;

import com.unicom.zimugeyjb.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/16 16:28 <br/>
 * @Author: yangjiabin
 */
@Repository
public class ArticleJDBCDao {

//    @Resource
//    private JdbcTemplate jdbcTemplate;


    //保存文章
    public void save(Article article,JdbcTemplate jdbcTemplate){
        //jdbcTemplate.update适合于insert update 和delete操作
        jdbcTemplate.update("insert into article(author,title,content,create_time) values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }


    //删除文章
    public void deleteById(Long id,JdbcTemplate jdbcTemplate){
        //jdbcTemplate.update适合于insert update 和delete操作
        jdbcTemplate.update("delete from article where id = ?",new Object[]{id});
    }

    //更新文章
    public void updateById(Article article,JdbcTemplate jdbcTemplate){
        //jdbcTemplate.update适合于insert update 和delete操作
        jdbcTemplate.update("update article set author = ? ,title = ? ,content = ?,create_time = ? where id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    //根据id查找文章
    public Article findById(Long id,JdbcTemplate jdbcTemplate){
        //queryForObject用于查询单条记录返回结果
        return (Article) jdbcTemplate.queryForObject("select * from article where id = ?",
                new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }


    //查询所有
    public List<Article> findAll(JdbcTemplate jdbcTemplate){
        //query查询列表结果
        return jdbcTemplate.query("select * from article",
               new BeanPropertyRowMapper<>(Article.class));
    }





}
