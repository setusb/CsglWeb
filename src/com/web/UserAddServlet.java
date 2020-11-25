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
 * @date 2020/11/25 8:56
 */
@WebServlet(name = "UserAddServlet",urlPatterns = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String password = request.getParameter("userpassword");
        String email = request.getParameter("email");
        String love = request.getParameter("love");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        if (name.length() != 0) {
            if (password.length() != 0) {
                if (email.length() != 0) {
                    if (love.length() != 0) {
                        boolean flag = studentDao.addingData(name, password, email, love);
                        if (flag) {
                            List<Student> list = studentDao.queryData();
                            request.setAttribute("list", list);
                            request.getRequestDispatcher("/userList.jsp").forward(request, response);
                        } else {
                            request.setAttribute("upassword", password);
                            request.setAttribute("uemail", email);
                            request.setAttribute("ulove", love);
                            request.setAttribute("name", "用户名不能重复");
                            request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("uname", name);
                        request.setAttribute("upassword", password);
                        request.setAttribute("uemail", email);
                        request.setAttribute("love", "请输入爱好");
                        request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("uname", name);
                    request.setAttribute("upassword", password);
                    request.setAttribute("email", "请输入邮箱");
                    request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("uname", name);
                request.setAttribute("password", "请输入密码");
                request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("name", "请输入用户名");
            request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
