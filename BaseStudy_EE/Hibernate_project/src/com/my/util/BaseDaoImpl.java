package com.my.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class BaseDaoImpl implements BaseDao
{
    
    @Override
    public void add(Object obj)
    {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        try
        {
            session.save(obj);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
        {
            SessionUtil.close(session);
        }
    }

    @Override
    public void delete(Object obj)
    {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        try
        {
            session.delete(obj);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
        {
            SessionUtil.close(session);
        }
    }

    @Override
    public void update(Object obj)
    {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        try
        {
            session.update(obj);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
        {
            SessionUtil.close(session);
        }
    }

    @Override
    public List queryAll(String hql)
    {
        Session session = SessionUtil.getSession();
        Query query = null;
        try
        {
            query = session.createQuery(hql);
            List list = query.list();
            return list;
        }
        catch (Exception e)
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
    public Object queryById(Class cls, Serializable id)
    {
        Session session = SessionUtil.getSession();
        try
        {
            return session.get(cls, id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            SessionUtil.close(session);
        }
        return null;
    }

}
