package lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �����ݿ�ı��в����¼�����Ӽ�¼���޸ļ�¼
 * @author pc
 *
 */

public class JdbcDemo2 {
	public static void main(String[] args) {
		
		//�����ݿ�ı������Ӽ�¼��ɾ����¼���޸ļ�¼
		try {
			//����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�������ݿ�, java.sql.Connection
			String url = "jdbc:oracle:thin:@192.168.1.100:1521:ORCL";
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			Statement stmt = con.createStatement();
			//String sql = "insert into bbs_user values(1,'zhangsan',25,'zhangS@163.com')";
			String sql = "delete bbs_user where name='zhangsan'";
			//String sql = "update bbs_user set age=30,email='zhangsan@163.com' where name='zhangsan'";
			
			//���ص���Ӱ��ļ�¼����
			int n = stmt.executeUpdate(sql);  //ʹ��executeUpdate����
			System.out.println(n);
			
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
