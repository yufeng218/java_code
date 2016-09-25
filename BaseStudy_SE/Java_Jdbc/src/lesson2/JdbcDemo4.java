package lesson2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**  ���ݿ�
 * create table test(
 *  id int primary key
 *  );
 * @author pc
 *
 */

public class JdbcDemo4 {

	public static void main(String[] args) {
		
try {
			
			Connection con = JdbcUtil.getConn();
			String sql = "insert into test values(?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			for(int i = 1; i <= 1000; i++){
				pstmt.setInt(1, i);
				pstmt.addBatch();	//��һ�������ӵ�pstmt��������������
				if(i % 10 == 0){	//ÿ10������һ�β���
					pstmt.executeBatch(); //��������
					pstmt.clearBatch();	  //��մ� pstmt�ĵ�ǰSQL�����б�
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
