package com.my.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
    public String login() throws Exception
    {
        System.out.println("loginOK...");
        return "loginOK";
    }
    
    public String register() throws Exception
    {
        return "registerOK";
    }
    
}
