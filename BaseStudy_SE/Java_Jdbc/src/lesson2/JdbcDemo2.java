package lesson2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class JdbcDemo2 {
	public static void main(String[] args) {
		
		try {
			
			Connection con = JdbcUtil.getConn();
			//��ȡ���ݿ���ص���Ϣ
			DatabaseMetaData dmd = con.getMetaData(); 
			System.out.println(dmd.getDatabaseProductVersion());
			System.out.println(dmd.getDatabaseProductName());
		
			PreparedStatement pstmt = con.prepareStatement("select * from bbs_user");
			ResultSet rs = pstmt.executeQuery();
			//��ȡ�������Ϣ
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount(); //��ȡ����
			for(int i = 1; i <= cols; i++){
				System.out.println(rsmd.getColumnName(i));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
