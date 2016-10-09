package com.my.code;

public class User
{
    private String username;
    private String password;

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
    
    public String userFind()
    {
        if(username.equals("zhangsan") && password.equals("123456"))
        {
            return "success";
        }
        else
        {
            return "failure";
        }
//        return "success";
    }

}
