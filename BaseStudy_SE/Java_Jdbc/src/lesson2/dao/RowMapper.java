package lesson2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	public T getRowMapper(ResultSet rs) throws SQLException;
}
