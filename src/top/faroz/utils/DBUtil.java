package top.faroz.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;
import java.util.jar.JarEntry;

/**
 * @ClassName DBUtil
 * @Description 数据库工具类
 * @Author FARO_Z
 * @Date 2020/11/13 3:42 下午
 * @Version 1.0
 **/
public class DBUtil {
    private static final String url="jdbc:mysql:///school_management_db?useUnicode=true&characterEncoding=utf8";
    private static final String name="admin";
    private static final String password="123";

    /**
     * 静态代码块
     * 注入JDBC连接
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得JDBC连接
     * @return 连接Connection conn
     */
    public static Connection getConnection() {
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(url, name, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * util.date转换成sql.date
     * @param date
     * @return
     */
    public static java.sql.Date javaDateToSqlDate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    /**
     * sql.date转换成util.date
     * @param date
     * @return
     */
    public static java.util.Date sqlDateToJavaDate(java.sql.Date date) {
        java.util.Date utilDate = new java.util.Date(date.getTime());
        return utilDate;
    }
}
