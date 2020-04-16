package com.easy.example.staticfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("PersonFactory.xml");
        Person chinese=context.getBean("chinese",Person.class);
        Person american=context.getBean("american",Person.class);
    }
}
