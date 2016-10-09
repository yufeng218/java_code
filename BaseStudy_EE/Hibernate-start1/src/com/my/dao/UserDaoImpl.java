package com.my.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.bean.User;
import com.my.util.HibernateUtil;

public class UserDaoImpl implements UserDao
{

    @Override
    public void save(User u)
    {
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        
        try
        {
            session.save(u);
            tran.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            tran.rollback();
        }
        finally
        {
            session.close();
        }
        
    }

}
