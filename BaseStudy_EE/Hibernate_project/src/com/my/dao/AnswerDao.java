package com.my.dao;

import java.util.List;

import com.my.bean.Answer;

public interface AnswerDao
{
    //��������
    public void save(Answer a);
    
    //ͨ�������id����ѯ��
    public List listAnswerByQuestionId(Integer questionId);
}
