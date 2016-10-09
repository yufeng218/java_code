package com.my.bean;

public class SystemMember
{
    /*
     * create table systemMemberTable ( 
     * id int not null auto_increment, 
     * name varchar(20) default null, 
     * fullName varchar(20), 
     * password varchar(20),
     * privilege varchar(20), 
     * primary key (id) 
     * )
     */

    private Integer id;
    private String name;
    private String fullName;
    private String password;

    private String privilege;

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

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPrivilege()
    {
        return privilege;
    }

    public void setPrivilege(String privilege)
    {
        this.privilege = privilege;
    }

}
