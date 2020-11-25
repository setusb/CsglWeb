package com.web;

import com.dao.StudentDaoImpl;
import com.daomain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/24 20:52
 */
@WebServlet(name = "UserListServlet",urlPatterns = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.queryData();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}
