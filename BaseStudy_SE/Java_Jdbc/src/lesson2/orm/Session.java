package lesson2.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lesson1.User;
import lesson2.Account;
import lesson2.JdbcUtil;

public class Session {
	
	public static void main(String[] args) {
		Session session = new Session();
		
		//类名和表名相同，类的成员名和表的属性名相同
//		Account account = new Account(1002, 5555, "wangming");
//		System.out.println(getSql(account));
//		session.save(account);
		
		//类名和表名不相同，类的成员名和表的属性名相同
//		User user = new User(1000, "xxxx", 36, "xxx@163.com");
//		System.out.println(getSql(user));
//		session.save(user);
		
		//类名和表名不相同，类的成员名和表的属性名不相同
		UserInfo userInfo = new UserInfo(1001, "zhangsan", 42, "xxxxxxx");
		System.out.println(getSql(userInfo));
		session.save(userInfo);
	}
	/**
	 * 向数据库中增加一条记录; 哪个数据库obj对象所属类对应的表; 记录内容和对象的属性内容相同;
	 * 
	 * 思路： 获取insert into 表名 (字段1,字段2,...) values (?,?,..)
	 * 
	 * @param obj
	 * @return
	 */
	public static int save(Object obj) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			pstmt = getStatement(con, obj);
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			JdbcUtil.closeConnection();
		}
		return n;
	}
	
	private static PreparedStatement getStatement(Connection con, Object obj) throws SQLException{
		PreparedStatement pstmt = con.prepareStatement(getSql(obj));
		Class c = obj.getClass();
		Field[] fds = c.getDeclaredFields();
		try {
			
			for(int i = 0; i < fds.length; i++){
				fds[i].setAccessible(true);
				pstmt.setObject(i+1, fds[i].get(obj));
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	
	public static String getSql(Object obj) {
		StringBuffer s = new StringBuffer();
		String tableName = null;
		String fieldName = null;
		s.append("insert into ");
		Class c = obj.getClass();
		Entity entity = (Entity)c.getAnnotation(Entity.class);
		if(entity != null){
			tableName = entity.value();	//获取注解的数据(表名)
		} else {
			tableName = c.getSimpleName();	//获取类名(表名)
		}
		s.append(tableName).append("(");
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			TypeName typeName = fields[i].getAnnotation(TypeName.class);
			if(typeName != null){
				fieldName = typeName.value();
			} else {
				fieldName = fields[i].getName();
			}
			s = i == 0 ? s.append(fieldName) : s.append(",").append(fieldName);
		}
		s.append(") values ").append(getString(fields.length));
		return s.toString();
	}

	/**
	 * 得到类似(?,?,?,?)的字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getString(int length) {
		StringBuffer s = new StringBuffer();
		s.append("(");
		for (int i = 0; i < length; i++) {
			s = i == 0 ? s.append("?") : s.append(",?");
		}
		s.append(")");
		return s.toString();
	}

}
