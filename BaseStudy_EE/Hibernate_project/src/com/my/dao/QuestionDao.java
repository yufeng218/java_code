package com.my.dao;

import java.util.List;


import com.my.bean.Question;

public interface QuestionDao
{
    //查询所有的问题类型
    public List listQuestionType();
    
    //保存问题
    public void save(Question q);
    
    //查看所有的问题
    public List listQuestion();
}
