package lesson2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import lesson1.User;
import lesson2.dao.Demo1.AccountRowMapper;

public class Demo2 {

	public static void main(String[] args) {
		
		SupportDao<User> sd = new SupportDao<User>();
//		User user = sd.findById(6, "select * from bbs_user where id=?", new UserRowMapper());
//		System.out.println(user);
		
//		List<User> users = sd.find("select * from bbs_user where name=? and age=?", new UserRowMapper(), "liushu",42);
//		for (User user : users) {
//			System.out.println(user);
//		}
		
//		List<User> users = sd.findByPage(2, 5, "select * from bbs_user limit ?,?", new UserRowMapper());
//		for (User user : users) {
//			System.out.println(user);
//		}
		
		int n = sd.saveOrUpdateOrDelete("insert into bbs_user values(?,?,?,?)", 2,"liming",26,"lingming@126.com");
		System.out.println(n);
		
		
	}
	static class UserRowMapper implements RowMapper<User>{

		@Override
		public User getRowMapper(ResultSet rs) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setAge(rs.getInt("age"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			return user;
		}
		
	}
}
