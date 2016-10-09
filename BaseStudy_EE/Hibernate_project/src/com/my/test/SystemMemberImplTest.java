package com.my.test;

import com.my.bean.SystemMember;
import com.my.dao.SystemMemberDaoImpl;

public class SystemMemberImplTest
{
    static SystemMemberDaoImpl dao = new SystemMemberDaoImpl();
    
    public static void main(String[] args)
    {
        testRegister();
    }
    
    public static void testRegister()
    {
        SystemMember sm = new SystemMember();
        sm.setFullName("test");
        sm.setName("zhangsan");
        sm.setPassword("123456");
        
        dao.register(sm);
    }
    
    
}
