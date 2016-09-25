package lesson2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**  数据库
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
				pstmt.addBatch();	//将一组参数添加到pstmt的批处理命令中
				if(i % 10 == 0){	//每10个插入一次操作
					pstmt.executeBatch(); //返回数组
					pstmt.clearBatch();	  //清空此 pstmt的当前SQL命令列表
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
