package com.my.ssh.dao;

import java.util.List;

/**
 * BaseDao接口
 */
public interface BaseDao<T>
{
	//写操作
	public void saveEntity(T t);	//保存
	public void saveOrUpdateEntity(T t);//保存或修改
	public void updateEntity(T t);	//修改
	public void deleteEntity(T t);	//删除
	public void batchEntityByHQL(String hql, Object ... objects);//批量更新
	
	//读操作
	public T loadEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntityByHQL(String hql, Object ... objects);
	
}
