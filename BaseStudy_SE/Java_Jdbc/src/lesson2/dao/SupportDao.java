package lesson2.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lesson2.JdbcUtil;

public class SupportDao<T> implements Dao<T> {

	@Override
	public T findById(Serializable id, String sql, RowMapper<T> rowMapper) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T t = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setObject(1, id); //
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 具体的表材质到如何包装
				t = rowMapper.getRowMapper(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
			JdbcUtil.closeConnection();
		}
		return t;
	}

	@Override
	public List<T> find(String sql, RowMapper<T> rowMapper, Object... obj) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);

			// 存入sql语句需要的条件
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rowMapper.getRowMapper(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
			JdbcUtil.closeConnection();
		}

		return list;
	}

	@Override
	public List<T> findByPage(int page, int size, String sql, RowMapper<T> rowMapper) {
		int begin = (page-1)*size;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setObject(1, begin);
			pstmt.setObject(2, size);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(rowMapper.getRowMapper(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
			JdbcUtil.closeConnection();
		}
		return list;
	}

	@Override
	public int saveOrUpdateOrDelete(String sql, Object... obj) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement(sql);
			// 存入sql语句需要的条件
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			JdbcUtil.closeConnection();
		}
		return n;
	}

}
