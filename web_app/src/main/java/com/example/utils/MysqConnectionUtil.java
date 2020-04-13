package com.example.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqConnectionUtil {

    private static MysqConnectionUtil connectionUtil=new MysqConnectionUtil();



    private MysqConnectionUtil(){

    }

    public static MysqConnectionUtil getInstance(){
        if(connectionUtil==null){
            synchronized (MysqConnectionUtil.class){
                if (connectionUtil==null){
                    connectionUtil=new MysqConnectionUtil();
                }
            }
        }
        return connectionUtil;
    }

    public Connection getConnection() throws Exception {
        Connection conn;

        Properties properties=new Properties();
        properties.load(this.getClass().getResourceAsStream("mysql.properties"));

        String driver;
        String url;
        String username;
        String password;

        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

        Class.forName(driver);

        conn= DriverManager.getConnection(url,username,password);
        return conn;

    }
}
