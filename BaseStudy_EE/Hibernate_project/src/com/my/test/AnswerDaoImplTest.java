package com.my.test;

import java.util.List;

import com.my.bean.Answer;
import com.my.bean.Question;
import com.my.bean.QuestionType;
import com.my.bean.SystemMember;
import com.my.dao.AnswerDao;
import com.my.dao.AnswerDaoImpl;
import com.my.dao.QuestionDao;
import com.my.dao.QuestionDaoImpl;
import com.my.util.BaseDao;
import com.my.util.BaseDaoImpl;

public class AnswerDaoImplTest
{
    static AnswerDao dao = new AnswerDaoImpl();
    static BaseDao baseDao = new BaseDaoImpl();
    
    public static void main(String[] args)
    {
        listAnswerByQuestionIdTest();
    }
    
    public static void testSave()
    {
        Question q = (Question) baseDao.queryById(Question.class, 1);
        
        Answer a = new Answer();
        a.setContent("java so easy.");
        a.setCreateTime("2016-05-01");
        a.setQ(q);//保存问题
        dao.save(a);
    }
    
    public static void listAnswerByQuestionIdTest()
    {
        List list = dao.listAnswerByQuestionId(1);
        System.out.println("问题ID为1的答案个数："+list.size());
    }
}
