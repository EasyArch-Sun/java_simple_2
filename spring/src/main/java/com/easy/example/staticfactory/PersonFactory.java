package com.easy.example.staticfactory;

public class PersonFactory {

    public Person getPerson(String person){
        if(person.equalsIgnoreCase("chinese")){
            return new Chinese();
        }else {
            return new American();
        }
    }
}
