package com.unicom.zimugeyjb.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/23 18:36 <br/>
 * @Author: yangjiabin
 */
//标记Servlet，以便启动器扫描
@WebServlet(name = "firstServlet",urlPatterns = "/firstServlet")
@Slf4j
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("servlet ");
        //super.doGet(req, resp);
        resp.getWriter().append("firstServlet");
    }
}
