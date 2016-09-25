package lesson.xml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionsTableTest {

	public static void main(String[] args) {
		find();
	}
	
	public static void find(){
		Connection connection = JdbcUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		String sql = "select * from questions";
		try {
			
			pstmt = connection.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			while(rSet.next()){
				System.out.println("title:"+rSet.getString("title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
