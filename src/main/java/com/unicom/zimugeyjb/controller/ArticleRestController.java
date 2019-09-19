package com.unicom.zimugeyjb.controller;

import com.unicom.zimugeyjb.dao.ArticleDao;
import com.unicom.zimugeyjb.model.AjaxResponse;
import com.unicom.zimugeyjb.model.Article;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/9 14:30 <br/>
 * @Author: yangjiabin
 */

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    MongoRepository mongoRepository;

    @Autowired
    ArticleDao articleDao;

    @Autowired
    MongoTemplate mongoTemplate;


    @ApiOperation(value = "添加文章" , notes = "添加新的文章" ,tags = "Article" , httpMethod= "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "title", value = "文章标题" , required = true ,defaultValue = ""),
//            @ApiImplicitParam(name = "content", value = "文章内容" , required = true ,defaultValue = ""),
//            @ApiImplicitParam(name = "author", value = "作者" , required = true ,defaultValue = "")
//    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功" ,response = AjaxResponse.class),
            @ApiResponse(code = 400,message = "用户输入错误" ,response = AjaxResponse.class),
            @ApiResponse(code = 500,message = "系统内部错误" ,response = AjaxResponse.class)

    })
    //@RequestMapping(value = "/article",method = RequestMethod.POST, produces = "application/json")
    @PostMapping("/article")
    //public AjaxResponse saveArticle(   Article article){
    //@RequestBody  不加这个注释好像接受不到数据
    public AjaxResponse saveArticle(@RequestBody   Article article){
        log.info("saveArticle:{}",article);

        mongoRepository.save(article);

        return AjaxResponse.success(article);
    }

    //@RequestMapping(value = "/article",method = RequestMethod.POST, produces = "application/json")
    @PostMapping("/article2")
    //public AjaxResponse saveArticle(   Article article){
    //@RequestBody  不加这个注释好像接受不到数据
    public AjaxResponse saveArticle2(@RequestParam   String id,
                                     @RequestParam   String author){
        log.info("saveArticle:{}",author);
        return AjaxResponse.success(author);
    }


    //@RequestMapping(value = "/article/{id}",method = RequestMethod.DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(   @PathVariable String id){
        //public AjaxResponse saveArticle(@RequestBody   Article article){
        log.info("deleteArticle:{}",id);

        mongoRepository.deleteById(id);

        return AjaxResponse.success(id);
    }

    //@RequestMapping(value = "/article/{id}",method = RequestMethod.PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(   @PathVariable Long id,@RequestBody Article article){
        //public AjaxResponse saveArticle(@RequestBody   Article article){
        log.info("updateArticle:{}",article);

        mongoRepository.save(article);

        return AjaxResponse.success(article);
    }


    //@RequestMapping(value = "/article/{id}",method = RequestMethod.GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(   @PathVariable String id){
        //public AjaxResponse saveArticle(@RequestBody   Article article){

        Optional<Article> article = mongoRepository.findById(id);
        log.info("updateArticle:{}",article.get());
        return AjaxResponse.success(article.get());
    }

    @GetMapping("/article")
    public @ResponseBody AjaxResponse getAll(){
        return AjaxResponse.success(mongoRepository.findAll());
    }

    @GetMapping("/getArticleByAuthor")
    public @ResponseBody AjaxResponse getByAuthor(String author){
        //return AjaxResponse.success(articleDao.findByAuthor(author));

        Query query = new Query(Criteria.where("author").is("yangjiabin"));
        List<Article> articles = mongoTemplate.find(query, Article.class);
        return AjaxResponse.success(articles.get(0));
    }

    /**
     {
         "id": 1,
         "author": "yangjiabin",
         "title": "我是标题",
         "content": "我是内容",
         "createTime": "",
             "reader": [
                 {
                     "name": "zhangsan",
                     "age": 18
                 },
                 {
                     "name": "lisi",
                     "age": 28
                 }
             ]
             }
     */

}
