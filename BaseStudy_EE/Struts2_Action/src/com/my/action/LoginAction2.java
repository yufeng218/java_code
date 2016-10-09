package com.my.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction2 extends ActionSupport 
    implements ServletRequestAware, ServletResponseAware
{
    
    public HttpServletRequest request;
    public HttpServletResponse reponse;
    
    @Override
    public String execute() throws Exception
    {
        if(username != null && username.equals("amake"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return SUCCESS;
        }
        this.setTip("”√ªß√˚√‹¬Î¥ÌŒÛ");
        return INPUT;
    }

    @Override
    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    } 

    @Override
    public void setServletResponse(HttpServletResponse response)
    {
        this.reponse = response;
    }
    
    private String username;
    private String password;
    private String tip;
    
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
    
    public String getTip()
    {
        return tip;
    }

    public void setTip(String tip)
    {
        this.tip = tip;
    }

   
}
