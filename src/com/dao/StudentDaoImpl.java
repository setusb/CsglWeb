package com.dao;

import com.daomain.Student;
import com.util.DatabaseImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/24 17:50
 */
public class StudentDaoImpl extends DatabaseImpl implements StudentDao {
    @Override
    public boolean login(String name, String password) {
        try {
            linkDatabase();
            ResultSet rs = inquiryDatabase("select * from student where name = '" + name + "' and password = '" + password + "'");
            while (rs.next()) {
                if (rs.getString("name").equals(name) && rs.getString("password").equals(password)) {
                    return true;
                }
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> queryData() {
        List<Student> list = new ArrayList<>();
        try {
            linkDatabase();
            ResultSet rs = inquiryDatabase("select * from student");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setEmail(rs.getString("email"));
                student.setLove(rs.getString("love"));
                list.add(student);
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteData(int id) {
        try {
            linkDatabase();
            int i = modifyDatabase("delete from student where id = '" + id + "'");
            if (i > 0) {
                closeDatabase();
                return true;
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addingData(String name, String password, String email, String love) {
        try {
            linkDatabase();
            int i = modifyDatabase("insert student(name,password,email,love) values ('" + name + "','" + password + "','" + email + "','" + love + "')");
            if (i > 0) {
                closeDatabase();
                return true;
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> querySingleData(String name) {
        List<Student> list = new ArrayList<>();
        try {
            linkDatabase();
            ResultSet rs = inquiryDatabase("select * from student where name = '" + name + "'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setEmail(rs.getString("email"));
                student.setLove(rs.getString("love"));
                list.add(student);
            }
            closeDatabase();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replaceMemberData(String uData, String data,String name) {
        try {
            linkDatabase();
            int i = modifyDatabase("update student set "+name+" = replace("+name+",'"+uData+"','"+data+"')");
            if (i > 0) {
                closeDatabase();
                return true;
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
