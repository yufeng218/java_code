package com.my.util;

import java.io.Serializable;
import java.util.List;

public interface BaseDao
{
    //添加
    public void add(Object obj);
    
    //删除
    public void delete(Object obj);
    
    //修改
    public void update(Object obj);
    
    //查询全部
    public List  queryAll(String hql);
    
    //按ID查询
    public Object queryById(Class cls, Serializable id);
}
