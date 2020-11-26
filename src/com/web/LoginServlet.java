package com.web;

import com.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/24 18:15
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        boolean flag = studentDao.login(name, password);
        String str = "你输入的密码或用户名错误";
        if (flag) {
            request.setAttribute("userName",name);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
