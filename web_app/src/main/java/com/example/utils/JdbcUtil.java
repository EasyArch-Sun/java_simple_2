package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;

    static {
        try {
            InputStream is=JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties=new Properties();
            properties.load(is);

            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs){
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
