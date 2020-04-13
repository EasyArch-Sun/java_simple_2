package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;

public class UserServiceImp {

    private UserDao userDao=new UserDao();

    public User findUserById(String id){
        return userDao.findByUserId(id);
    }

    public User findUserByNameAndPassword(String username,String password){
        return userDao.findByNameAndPAssword(username,password);
    }


}
