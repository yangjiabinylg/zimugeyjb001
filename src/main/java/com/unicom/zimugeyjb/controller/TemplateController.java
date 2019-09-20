package com.unicom.zimugeyjb.controller;

import com.unicom.zimugeyjb.model.ArticleVo;
import com.unicom.zimugeyjb.service.ArticleRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/20 19:23 <br/>
 * @Author: yangjiabin
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name = "articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model, HttpSession session){
        List<ArticleVo> articleVos = articleRestService.getAll();

        model.addAttribute("articles",articleVos);

        Map<String ,String > user = new HashMap<>();
        user.put("id","1");
        user.put("username","yang");
        //user.put("username",null);
        user.put("password","ayngjaibin1111");

        model.addAttribute("user",user);

        session.setAttribute("foo","dddddddd");


        //模板名称，实际的目录为 ：resources/templates/thymeleaftemp.html
        return "thymeleaftemp";
    }

}
