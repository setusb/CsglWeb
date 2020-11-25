package com.web;

import com.dao.StudentDaoImpl;
import com.daomain.Student;
import com.sun.xml.internal.bind.v2.model.core.ID;

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
 * @date 2020/11/24 21:55
 */
@WebServlet(name = "UserRemoveServlet",urlPatterns = "/UserRemoveServlet")
public class UserRemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        StudentDaoImpl studentDao = new StudentDaoImpl();
        System.out.println(userId);
        studentDao.deleteData(userId);
        List<Student> list = studentDao.queryData();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}
