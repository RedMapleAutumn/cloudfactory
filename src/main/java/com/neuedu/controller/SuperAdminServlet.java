package com.neuedu.controller;

import com.neuedu.entity.Admin;
import com.neuedu.service.UserMana;
import com.neuedu.service.impl.UserManaImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/superAdmin")
public class SuperAdminServlet extends HttpServlet {
    UserMana userMana = new UserManaImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method==null){
            method = "findAll";
        }
        String account = req.getParameter("account");
        switch (method){
            case "findAll":
                List<Admin> list = userMana.findAll();
                int num = 0;
                req.setAttribute("list",list);
                req.setAttribute("num",num);
                req.getRequestDispatcher("superAdminHome.jsp").forward(req,resp);
                break;
            case "modify":
                Admin admin = userMana.findByAccount(account);
                req.setAttribute("user",admin);
                req.getRequestDispatcher("modifyUser.jsp").forward(req,resp);
                break;
            case "delete":
                String result = userMana.deleteUser(account);
                resp.sendRedirect("/superAdmin?method=findAll");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if(method==null){
            method = "search";
        }
        switch (method){
            case "search":
                String username = req.getParameter("search");
                if(username.equals("")){
                    resp.sendRedirect("/superAdmin?method=findAll");
                }else {
                    List<Admin> list = userMana.findAllByUsername(username);
                    int num = 0;
                    req.setAttribute("list",list);
                    req.setAttribute("num",num);
                    req.getRequestDispatcher("superAdminHome.jsp").forward(req,resp);
                }
                break;
            case "modified":
                String account = req.getParameter("account");
                String name = req.getParameter("username");
                String tel = req.getParameter("contact");
                String result = userMana.updateUser(name,tel,account);
                if(result.equals("更新成功")){
                    resp.sendRedirect("/superAdmin?method=findAll");
                }
                break;
        }



    }
}
