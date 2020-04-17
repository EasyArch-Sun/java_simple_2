package com.easy.example.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("AnnotationTest.xml");
        Company company=applicationContext.getBean("company",Company.class);
        company.getUserName();
    }
}
