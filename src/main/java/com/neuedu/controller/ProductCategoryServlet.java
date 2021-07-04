package com.neuedu.controller;

import com.neuedu.entity.Factory;
import com.neuedu.entity.ProductCategory;
import com.neuedu.service.PCategoryService;
import com.neuedu.service.impl.PCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productCategory")
public class ProductCategoryServlet extends HttpServlet {
    PCategoryService pCategoryService = new PCategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> list = pCategoryService.findAll();
        int num = 0;
        req.setAttribute("num",num);
        req.setAttribute("list",list);
        req.getRequestDispatcher("productCategoryMana.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        if(method==null){
            method = "add";
        }
        switch (method){
            case "add":
                String name = req.getParameter("name");
                if(name==null){
                    resp.getWriter().write("null");
                }else{
                    String result = pCategoryService.add(name);
                    resp.sendRedirect("/productCategory");
                }
                break;
            case "search":
                String fname = req.getParameter("search");
                if(fname.equals("")){
                    resp.sendRedirect("/productCategory?method=findAll");
                }else{
                    List<ProductCategory> list = pCategoryService.findAllByName(fname);
                    int num = 0;
                    req.setAttribute("num",num);
                    req.setAttribute("list",list);
                    req.getRequestDispatcher("productCategoryMana.jsp").forward(req,resp);
                }
                break;
            default:break;
        }
    }
}
