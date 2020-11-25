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
 * @date 2020/11/25 12:52
 */
@WebServlet(name = "UserUpdateServlet",urlPatterns = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upassword = request.getParameter("upassword");
        String uemail = request.getParameter("uemail");
        String ulove = request.getParameter("ulove");

        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String love = request.getParameter("love");

        StudentDaoImpl studentDao = new StudentDaoImpl();
        if (name.length() != 0) {
            boolean flag = studentDao.replaceMemberData(uname, name, "name");
            System.out.println(flag);
            if (!flag) {
                List<Student> list = studentDao.querySingleData(uname);
                request.setAttribute("list", list);
                request.setAttribute("unName", "用户名不能重复");
                request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);
            }
        }
        if (password.length() != 0) {
            studentDao.replaceMemberData(upassword, password, "password");
        }
        if (email.length() != 0) {
            studentDao.replaceMemberData(uemail, email, "email");
        }
        if (love.length() != 0) {
            studentDao.replaceMemberData(ulove, love, "love");
        }
        List<Student> list = studentDao.queryData();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.querySingleData(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);
    }
}
