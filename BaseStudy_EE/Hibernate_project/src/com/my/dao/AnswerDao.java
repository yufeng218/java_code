package com.my.dao;

import java.util.List;

import com.my.bean.Answer;

public interface AnswerDao
{
    //保存问题
    public void save(Answer a);
    
    //通过问题的id来查询答案
    public List listAnswerByQuestionId(Integer questionId);
}
