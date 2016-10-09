package com.my.action;

import com.my.bean.SystemMember;
import com.my.dao.SystemMemberDao;
import com.my.dao.SystemMemberDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
    private SystemMemberDao dao = new SystemMemberDaoImpl();
    
    @Override
    public String execute() throws Exception
    {
        SystemMember sm = dao.login(name, password);
        if(sm != null)
        {
            //将用户信息保存到session中
            ActionContext.getContext().getSession().put("SM", sm);
            return "main_page";
        }
        else
        {
            this.setTip("name or password error,please reLogin!");
            return INPUT;
        }
        
    }

    private String name;
    private String password;
    private String tip;
    
    public String getTip()
    {
        return tip;
    }

    public void setTip(String tip)
    {
        this.tip = tip;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
