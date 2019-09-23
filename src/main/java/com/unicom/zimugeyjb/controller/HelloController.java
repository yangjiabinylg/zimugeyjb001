package com.unicom.zimugeyjb.controller;

import com.unicom.zimugeyjb.model.ArticleVo;
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
        ArticleVo article = new ArticleVo();
        article.setId(111L);
        article.setAuthor("dddd");
        article.setAuthor("hello222ddd");
        log.info("article={}",article.toString());
        return article.toString();
    }

    //****************************************************
    @RequestMapping("/hello2")
    public String hello2(){

        //ArticleVo article = new ArticleVo(111221L,"sss1111");
        ArticleVo article = new ArticleVo();
        article.setId(111L);
        article.setAuthor("dddd");
        article.setAuthor("hello222ddd");
        log.info("article={}",article.toString());

        ArticleVo article1 = ArticleVo.builder().id(2L).author("jjj").build();
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
