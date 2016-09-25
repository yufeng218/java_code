package lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) {

		try {
			// 1.����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�������, java.sql.Connection
			String url = "jdbc:oracle:thin:@192.168.1.100:1521:ORCL";
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			// 3.ִ��sql��䣬 java.sql.Statement
			Statement stmt = con.createStatement();
			String sql = "select empno,ename,job,sal from emp";
			ResultSet rs = stmt.executeQuery(sql); // �õ��Ľ����
			// 4.���ʽ����
			while (rs.next()) {
				//��ȡ�ڼ��е�����
				//System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4));
				System.out.println(rs.getInt("empno") + "," + rs.getString("ename") + "," + rs.getString("job") + "," + rs.getString("sal"));
			}

			// 5.�ر���Դ ---> �쳣���洦��
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
