package com.example.servlet;

import com.example.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserServiceImp userSericeImp=new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //查询用户名和密码是否在数据库中

        resp.setCharacterEncoding("UTF-8");
        if(userSericeImp.findUserByNameAndPassword(username,password)==null){
            resp.getWriter().println("用户不存在或用户名密码错误");
        }
        resp.getWriter().println("hello"+username);
    }
}
