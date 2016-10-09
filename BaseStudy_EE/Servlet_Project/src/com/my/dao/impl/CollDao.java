package com.my.dao.impl;

import java.util.List;

import com.my.bean.CollectionBean;

public interface CollDao<T>
{
    public void save(CollectionBean bean);
    
    public void update(CollectionBean bean);
    
    public void delete(String[] s);
    
    public List<T> list();
}
