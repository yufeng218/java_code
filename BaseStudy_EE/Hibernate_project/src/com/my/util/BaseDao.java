package com.my.util;

import java.io.Serializable;
import java.util.List;

public interface BaseDao
{
    //���
    public void add(Object obj);
    
    //ɾ��
    public void delete(Object obj);
    
    //�޸�
    public void update(Object obj);
    
    //��ѯȫ��
    public List  queryAll(String hql);
    
    //��ID��ѯ
    public Object queryById(Class cls, Serializable id);
}
