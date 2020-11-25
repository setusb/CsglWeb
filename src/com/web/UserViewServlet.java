package com.web;

import com.dao.StudentDaoImpl;
import com.daomain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/25 12:38
 */
@WebServlet(name = "UserViewServlet",urlPatterns = "/UserViewServlet")
public class UserViewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.querySingleData(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userView.jsp").forward(request, response);
    }
}
