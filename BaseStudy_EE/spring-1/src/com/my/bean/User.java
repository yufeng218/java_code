package com.my.bean;

public class User{
    
    private Integer age;
    
    private String name;
    
    //���췽��
    public User(Integer age, String name)
    {
        this.age = age; this.name = name;
    }
    
    public Integer getAge()
    {
        return age;
    }
    
    public String getName()
    {
        return name;
    }
}