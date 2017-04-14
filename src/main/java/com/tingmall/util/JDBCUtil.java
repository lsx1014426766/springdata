package com.tingmall.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by lsx on 2017/4/13.
 */
public class JDBCUtil {

    public static Connection getConnection() throws Exception {
       /* String url="jdbc:mysql:///springdata";
        String user="root";
        String pwd="root";
        String driverClass="com.mysql.jdbc.Driver";*/
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);


        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String pwd = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection conn= DriverManager.getConnection(url,user,pwd);
        return conn;

    }
    //alt_enter 导入缺失包
    public static void release(ResultSet resultSet,
                               Statement statement, Connection connection){

        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
