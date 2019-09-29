package com.unicom.zimugeyjb.controller;

import com.unicom.zimugeyjb.config.exception.htmlPageException.ModeViewMe;
import com.unicom.zimugeyjb.service.ExceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/25 19:14 <br/>
 * @Author: yangjiabin
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    /**
     1091947832@qq.com
     1091947832qq.com
     1091947832@qqcom
     1091947832qqcom
     13758194469
     */

    @Resource
    ExceptionService exceptionService;

    @ModeViewMe
    @GetMapping("/freemarker")
    public ModelAndView index(Model model){


//        model.addAttribute("map","yangjiabin");
//
       /**   故意出错   */
       exceptionService.systemBizError();
//
//       return "success";

        ModelAndView modelAndView = new ModelAndView();

        /**  跳转error页面   */
        modelAndView.setViewName("success");

        //返回ModelView
        return modelAndView;
   }




}
