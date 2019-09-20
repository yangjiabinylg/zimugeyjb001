package com.unicom.zimugeyjb.controller;

import com.unicom.zimugeyjb.model.ArticleVo;
import com.unicom.zimugeyjb.service.ArticleRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/20 18:26 <br/>
 * @Author: yangjiabin
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name = "articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;



    @GetMapping("/jsp")
    public String index(String name , Model model){

        List<ArticleVo> articleVoList = articleRestService.getAll();

        model.addAttribute("articles",articleVoList);

        //模板名称，实际目录为：src/main/webapp/WEB-INF/jsp/jsptemp.jsp
        return "jsptemp";
    }
}
