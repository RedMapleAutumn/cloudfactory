package com.neuedu.controller;

import com.neuedu.entity.Factory;
import com.neuedu.service.FactoryService;
import com.neuedu.service.impl.FactoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cloudFactory")
public class CloudFacotryManaServlet extends HttpServlet {
    FactoryService factoryService = new FactoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method==null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                List<Factory> list = new ArrayList<>();
                list = factoryService.findAll();
                int num = 0;
                req.setAttribute("num",num);
                req.setAttribute("list",list);
                req.getRequestDispatcher("cloudFactoryMana.jsp").forward(req,resp);
                break;
            case "stop": //关停操作：将工厂状态设为0
                String FNO = req.getParameter("FNO");
                String result = factoryService.changeFactoryState(FNO,"0");
                if(result.equals("更新成功")){
                    resp.sendRedirect("/cloudFactory?method=findAll");
                }
                break;
            case "start":
                String FNO2 = req.getParameter("FNO");
                String result2 = factoryService.changeFactoryState(FNO2,"1");
                if(result2.equals("更新成功")){
                    resp.sendRedirect("/cloudFactory?method=findAll");
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fname = req.getParameter("search");
        if(fname.equals("")){
            resp.sendRedirect("/cloudFactory?method=findAll");
        }else{
            List<Factory> list = factoryService.findAllByName(fname);
            int num = 0;
            req.setAttribute("num",num);
            req.setAttribute("list",list);
            req.getRequestDispatcher("cloudFactoryMana.jsp").forward(req,resp);
        }

    }
}
