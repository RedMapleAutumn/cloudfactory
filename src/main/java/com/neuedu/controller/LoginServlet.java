package com.neuedu.controller;

import com.neuedu.entity.Admin;
import com.neuedu.entity.FactoryAdmin;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = loginService.login(username,password);
        if(admin!=null){
            HttpSession httpSession = req.getSession();
            String type = admin.getRole();
            switch (type){
                case "超级管理员":
                    httpSession.setAttribute("superAdmin",admin);
                    resp.sendRedirect("/superAdmin");
                    break;
                case "经销商":
                    httpSession.setAttribute("agency",admin);
                    resp.sendRedirect("agencyHome.jsp");
                    break;
                case "云工厂管理员":
                    FactoryAdmin factoryAdmin = (FactoryAdmin)admin;
                    httpSession.setAttribute("factoryAdmin",factoryAdmin);
                    resp.sendRedirect("");
                    break;
                default:
                    break;
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}
