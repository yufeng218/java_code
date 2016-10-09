package com.my.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.my.bean.Answer;
import com.my.util.BaseDaoImpl;
import com.my.util.SessionUtil;

public class AnswerDaoImpl extends BaseDaoImpl implements AnswerDao
{

    @Override
    public void save(Answer a)
    {
        super.add(a);
    }

    @Override
    public List listAnswerByQuestionId(Integer questionId)
    {
        //级联的形式写HQL，answer对象的Question对象的id
        String hql = "from Answer as a where a.q.id=?";
        Session session = SessionUtil.getSession();
        try
        {
            Query query = session.createQuery(hql);
            query.setInteger(0, questionId);
            List list = query.list();
            return list;
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

}
