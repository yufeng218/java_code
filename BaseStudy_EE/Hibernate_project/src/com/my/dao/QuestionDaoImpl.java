package com.my.dao;

import java.util.List;

import com.my.bean.Question;
import com.my.util.BaseDaoImpl;

public class QuestionDaoImpl extends BaseDaoImpl implements QuestionDao
{

    @Override
    public List listQuestionType()
    {
        String hql = "from QuestionType";
        return super.queryAll(hql);
    }

    @Override
    public void save(Question q)
    {
        super.add(q);
    }

    @Override
    public List listQuestion()
    {
        String hql = "from Question";
        return super.queryAll(hql);
    }

}
