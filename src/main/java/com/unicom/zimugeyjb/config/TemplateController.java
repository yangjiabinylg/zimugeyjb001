package com.unicom.zimugeyjb.config;

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
 * @Date: 2019/9/20 18:52 <br/>
 * @Author: yangjiabin
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name = "articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @GetMapping("/freemarker")
    public String index(Model model){

        List<ArticleVo> articleVos = articleRestService.getAll();

        model.addAttribute("articles",articleVos);

        //模板名称，实际的目录为，resources/templates/fremarkerttemp.html
        return "freemarkertemp";

    }


}
