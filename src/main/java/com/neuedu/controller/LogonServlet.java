package com.neuedu.controller;

import com.neuedu.service.LogonService;
import com.neuedu.service.impl.LogonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logon")
public class LogonServlet extends HttpServlet {
    LogonService logonService = new LogonServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String type = req.getParameter("type");
        String factoryname = req.getParameter("factoryname");
        String factoryintro = req.getParameter("factoryintro");

        String result = "";
        if(type.equals("经销商")){
            result = logonService.agencylogon(account,password,name,tel,type);
        }else {
            result = logonService.factoryadminlogon(account,password,name,tel,type,factoryname,factoryintro);
        }
        if(result.equals("账号重复")){
            resp.sendRedirect("logon.jsp");
        }
        String method = req.getParameter("method");

        resp.getWriter().write("结果:"+result+"<br>");
        resp.getWriter().write(account+password+name+tel+type+factoryname+factoryintro);

        if(method.equals("add")){
            resp.sendRedirect("/superAdmin");
        }
    }
}
