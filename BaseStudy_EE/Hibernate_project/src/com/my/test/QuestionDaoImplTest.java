package com.my.test;

import java.util.List;

import com.my.bean.Question;
import com.my.bean.QuestionType;
import com.my.bean.SystemMember;
import com.my.dao.QuestionDao;
import com.my.dao.QuestionDaoImpl;
import com.my.dao.SystemMemberDaoImpl;
import com.my.util.BaseDao;
import com.my.util.BaseDaoImpl;

public class QuestionDaoImplTest
{
    static QuestionDao dao = new QuestionDaoImpl();
    static BaseDao baseDao = new BaseDaoImpl();
    public static void main(String[] args)
    {
        //testSave();
        testListQuestion();
        testListQuestionType();
    }
    
    public static void testSave()
    {
        SystemMember sm = (SystemMember) baseDao.queryById(SystemMember.class, 1);
        QuestionType qt = (QuestionType) baseDao.queryById(QuestionType.class, 1);
        
        Question q = new Question();
        q.setCreateTime("2016-9-4");
        q.setQt(qt);// 问题的类型
        q.setSm(sm);// 对应的用户
        q.setAnswerCount(0); //问题回答的次数
        q.setContent("How to learn java ??");//问题的内容
        
        dao.save(q);
    }
    
    public static void testListQuestion()
    {
        List list = dao.listQuestion();
        System.out.println("问题个数："+list.size());
    }
    
    public static void testListQuestionType()
    {
        List list = dao.listQuestionType();
        System.out.println("问题类型个数："+list.size());
    }
}
