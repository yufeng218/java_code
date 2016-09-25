package lesson2;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
//import java.util.Date;
/*
 *     创建的数据量库
 * create table datetest(
 * id int primary key,
 * birthday date
 * );
 * 
 */
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class JdbcDemo3 {

	public static void main(String[] args) {
		java.util.Date date1 = new java.util.Date();
		java.sql.Date date = new java.sql.Date(date1.getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "insert into datetest values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1002);
			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String formateDate = sdf.format(date1);
//			System.out.println(formateDate);
			
//			pstmt.setDate(2, date);
			pstmt.setString(2, "1990-02-05");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			JdbcUtil.closeConnection();
		}
	}

}



