package lesson2.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	//������ѯ
	public T findById(Serializable id, String sql, RowMapper<T> rowMapper);
	
	//���������Ĳ�ѯ
	public List<T> find(String sql, RowMapper<T> rowMapper, Object...obj) throws SQLException;

	//��ҳ��ѯ
	public List<T> findByPage(int page, int size, String sql, RowMapper<T> rowMapper);

	//���ӻ�ɾ��
	public int saveOrUpdateOrDelete(String sql, Object...obj);
	
}
