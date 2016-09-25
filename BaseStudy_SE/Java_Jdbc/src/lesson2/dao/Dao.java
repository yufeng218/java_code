package lesson2.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	//主键查询
	public T findById(Serializable id, String sql, RowMapper<T> rowMapper);
	
	//不定参数的查询
	public List<T> find(String sql, RowMapper<T> rowMapper, Object...obj) throws SQLException;

	//分页查询
	public List<T> findByPage(int page, int size, String sql, RowMapper<T> rowMapper);

	//增加或删除
	public int saveOrUpdateOrDelete(String sql, Object...obj);
	
}
