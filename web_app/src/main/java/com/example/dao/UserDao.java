package com.example.dao;

import com.example.entity.User;
import com.example.utils.MysqConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User findByUserId(String id){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        User user=null;

        try {
            conn= MysqConnectionUtil.getInstance().getConnection();
            String sql="select * from user where id=?";
            st=conn.prepareStatement(sql);
            st.setString(1,id);

            rs=st.executeQuery();

            if(rs!=null&&rs.next()){
                user=new User();
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public User findByNameAndPAssword(String name,String password){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        User user=null;

        try {
            conn= MysqConnectionUtil.getInstance().getConnection();
            String sql="select * from user where name=? and password=?";
            st=conn.prepareStatement(sql);
            st.setString(1,name);
            st.setString(2,password);

            rs=st.executeQuery();

            if(rs!=null&&rs.next()){
                user=new User();
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public int insertUser(User user){
        Connection conn=null;
        PreparedStatement st=null;

        try {
            conn= MysqConnectionUtil.getInstance().getConnection();
            String sql="insert into user (id,name,password) values (?,?,?)";
            st=conn.prepareStatement(sql);
            st.setString(1,user.getId());
            st.setString(1,user.getName());
            st.setString(1,user.getPassword());


            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
