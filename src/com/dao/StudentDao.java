package com.dao;

import com.daomain.Student;

import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/24 17:47
 */
public interface StudentDao {
    /**
     * 登录功能
     * @param name 网页上获取的用户名
     * @param password 网页上获取的密码
     * @return 返回是否登录成功
     */
    boolean login(String name,String password);

    /**
     * 查询数据库所有成员
     * @return 返回数据成员数据
     */
    List<Student> queryData();

    /**
     * 删除数据库成员
     * @return 是否删除成功
     */
    boolean deleteData(int id);

    /**
     * 添加数据库成员
     * @param name 用户名
     * @param password 用户密码
     * @param email 邮箱
     * @param love 爱好
     * @return 是否添加成功
     */
    boolean addingData(String name, String password, String email, String love);

    /**
     * 查询单个成员数据
     * @param name 用户名
     * @return 返回单个成员数组
     */
    List<Student> querySingleData(String name);

    /**
     * 替换成员数据
     *
     * @param uData 原数据
     * @param data 现有数据
     * @param name 字段名
     * @return 是否替换成功
     */
    boolean replaceMemberData(String uData, String data, String name);
}
