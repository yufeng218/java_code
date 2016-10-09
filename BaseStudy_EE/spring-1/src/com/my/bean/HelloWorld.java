package com.my.bean;

public class HelloWorld
{
    private String name;
    
    public void setName_new(String name)
    {
        this.name = name;
    }
    
    public void hello()
    {
        System.out.println("hello: " + name);
    }
}
