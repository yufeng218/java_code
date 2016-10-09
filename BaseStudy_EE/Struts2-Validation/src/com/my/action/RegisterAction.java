package com.my.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport
{
    /*
    public void validate()
    {
        if(username==null || username.trim().equals(""))
        {
            String msg = "用户名称是必填项";
            this.addFieldError("username", msg);
        }
        if(password==null || password.trim().equals(""))
        {
            String msg = "用户密码是必填项";
            this.addFieldError("password", msg);
        }
    }
    */
    
    public String execute()
    {
        return SUCCESS;
    }
    
    private String username;
    private String password;
    private String url;
    private String email;
    private Date birthday;
    private int age;
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
   
    
}