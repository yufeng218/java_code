package com.my.dao;

import com.my.bean.SystemMember;

public interface SystemMemberDao
{
    //�û���¼
    public SystemMember login(String username, String password);
    
    //�û�ע��
    public void register(SystemMember sm);
    
    //����û��Ƿ����
    public boolean check(String username);
}
