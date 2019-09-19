package com.unicom.zimugeyjb.controller;

import com.unicom.zimugeyjb.model.Article;
import com.unicom.zimugeyjb.model.G;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/6 16:54 <br/>
 * @Author: yangjiabin
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello  world";
    }

    //****************************************************
    @RequestMapping("/hello2")
    public String hello2(){

        //Article article = new Article(111221L,"sss1111");
        Article article = new Article();
        article.setId("");
        article.setAuthor("dddd");
        article.setAuthor("hello222ddd");
        log.info("article={}",article.toString());

        Article article1 = Article.builder().id("").author("jjj").build();
        log.info("article1={}",article1.toString());
        return article.toString()+"+  hello  world  +"+article1.toString();
    }



    @RequestMapping("/hello3")
    public String hello3(){

         G g = new G();
         g.setMainImageUrl("xxxx.jpg");


         List<G.RecipeDtailItemVoListBean> listBeans = new ArrayList<>();
         G.RecipeDtailItemVoListBean recipeDtailItemVoListBean = new G.RecipeDtailItemVoListBean();
         recipeDtailItemVoListBean.setFridayDishName("你好啊啊啊");
         listBeans.add(recipeDtailItemVoListBean);
         g.setRecipeDtailItemVoList(listBeans);
         log.info("g.setMainImageUrl={}",g.getMainImageUrl());

         log.info("G.RecipeDtailItemVoListBean={}",g.getRecipeDtailItemVoList().get(0).getFridayDishName());
         return null;
    }
}
