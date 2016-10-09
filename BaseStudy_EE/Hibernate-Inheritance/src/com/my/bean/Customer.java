package com.my.bean;

import java.util.HashSet;
import java.util.Set;

public class Customer
{

    private Integer id;
    private String name;
    private String email;
    
    private Set<Order> orders = new HashSet<Order>();
    
    public Set getOrders()
    {
        return orders;
    }

    public void setOrders(Set orders)
    {
        this.orders = orders;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

}
