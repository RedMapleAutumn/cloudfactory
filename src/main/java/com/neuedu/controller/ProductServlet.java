package com.neuedu.controller;

import com.neuedu.entity.Product;
import com.neuedu.entity.ProductCategory;
import com.neuedu.repository.PCategoryRepo;
import com.neuedu.service.PCategoryService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.PCategoryServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    PCategoryService pCategoryService = new PCategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method==null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                List<Product> list = productService.findAll();
                List<ProductCategory> categorylist = pCategoryService.findAll();
                int num = 0;
                req.setAttribute("num",num);
                req.setAttribute("list",list);
                req.setAttribute("categorylist",categorylist);
                req.getRequestDispatcher("productMana.jsp").forward(req,resp);
                break;
            case "add":
                break;
        }
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
                String pname = req.getParameter("name");
                String category = req.getParameter("category");
                String size = req.getParameter("size");
                String description = req.getParameter("description");
                String result = productService.add(pname,category,size,description);
                resp.sendRedirect("/product");
                break;
            case "modify":
                String pno = req.getParameter("selectPNO");
                pname = req.getParameter("name");
                category = req.getParameter("category");
                size = req.getParameter("size");
                description = req.getParameter("description");
                resp.getWriter().write(pno+pname+category+size+description);
                break;
        }

    }
}
