//package com.unicom.zimugeyjb.generator;
//
//import com.unicom.zimugeyjb.generator.Article;
//import com.unicom.zimugeyjb.generator.ArticleExample;
//import java.util.List;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ArticleMapper {
//    long countByExample(ArticleExample example);
//
//    int deleteByExample(ArticleExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Article record);
//
//    int insertSelective(Article record);
//
//    List<Article> selectByExample(ArticleExample example);
//
//    Article selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);
//
//    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);
//
//    int updateByPrimaryKeySelective(Article record);
//
//    int updateByPrimaryKey(Article record);
//}