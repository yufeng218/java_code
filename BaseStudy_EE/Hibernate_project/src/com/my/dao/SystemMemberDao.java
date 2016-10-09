package com.my.dao;

import com.my.bean.SystemMember;

public interface SystemMemberDao
{
    //用户登录
    public SystemMember login(String username, String password);
    
    //用户注册
    public void register(SystemMember sm);
    
    //检查用户是否存在
    public boolean check(String username);
}
