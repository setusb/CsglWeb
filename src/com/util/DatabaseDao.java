package com.util;

import java.sql.ResultSet;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/22 20:54
 */
public interface DatabaseDao {
    /**
     * 数据库连接
     */
    void linkDatabase();

    /**
     * 查询数据库
     * @param sql 数据库查询指令
     * @return 返回结果集
     */
    ResultSet inquiryDatabase(String sql);

    /**
     * 修改数据库
     * @param sql 数据库查询指令
     * @return 返回1或者0
     */
    int modifyDatabase(String sql);

    /**
     * 关闭数据库
     */
    void closeDatabase();
}
