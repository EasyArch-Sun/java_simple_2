package com.easy.example.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Company {

    @Autowired
    public UserServiceImpl userService;

    public void getUserName(){
        userService.printName();
    }
}
