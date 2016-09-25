package org.my.bbs.dao.base;

public interface Dao<T>
{
	T findById(String id, String sql);
}
