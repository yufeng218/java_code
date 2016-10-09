package com.my.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport
{
    //
    @Override
    public String execute() throws Exception
    {
        if(username != null && username.equals("amake"))
        {
            /*
             * HttpServletRequest request
             * HttpSession session = request.getSession();
             * session.setAttribute("username", username);
             */
            ActionContext ac = ActionContext.getContext();
            Map<String, Object> session = ac.getSession();
            session.put("username", username);
            
            return SUCCESS;
        }
        this.setTip("�û����������");
        return INPUT;
    }
    
    //��֤
    @Override
    public void validate()
    {
        
    }

/*public class LoginAction implements Action
{
    //ʵ��Action�ӿ�
    //Action�ӿ����г����Ķ��壬execute()����
    @Override
    public String execute() throws Exception
    {
        if(username != null && username.equals("amake"))
        {
            return SUCCESS;
        }
        this.setTip("�û����������");
        return INPUT;
    }*/
    
    /*
    //��������ķ���execute
    public String execute() throws Exception
    {
        if(username != null && username.equals("amake"))
        {
            return "success";
        }
        this.setTip("�û����������");
        return "input";
    }*/
    
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
