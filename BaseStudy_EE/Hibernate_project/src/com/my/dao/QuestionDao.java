package com.my.dao;

import java.util.List;


import com.my.bean.Question;

public interface QuestionDao
{
    //��ѯ���е���������
    public List listQuestionType();
    
    //��������
    public void save(Question q);
    
    //�鿴���е�����
    public List listQuestion();
}
