package com.my.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.my.bean.SystemMember;
import com.my.util.BaseDaoImpl;
import com.my.util.SessionUtil;

public class SystemMemberDaoImpl extends BaseDaoImpl implements SystemMemberDao
{
    
    @Override
    public SystemMember login(String username, String password)
    {
        Session session = SessionUtil.getSession();
        String hql = "from SystemMember as sm where sm.name=? and sm.password=?";
        try
        {
            Query query = session.createQuery(hql);
            query.setString(0, username);
            query.setString(1, password);
            
            List list = query.list();
            if(list.size() > 0)
            {
                SystemMember sm = (SystemMember) list.get(0);
                return sm;
            }
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SessionUtil.close(session);
        }
        return null;
    }

    @Override
    public void register(SystemMember sm)
    {
        if(!check(sm.getName()))
        {
            super.add(sm);
        }
    }

    @Override
    public boolean check(String username)
    {
        Session session = SessionUtil.getSession();
        String hql = "from SystemMember as sm where sm.name=?";
        try
        {
            Query query = session.createQuery(hql);
            query.setString(0, username);
            
            List list = query.list();
            if(list.size() > 0)
            {
                return true;
            }
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SessionUtil.close(session);
        }
        return false;
    }

}
