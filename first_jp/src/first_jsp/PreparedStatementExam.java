package first_jsp;


 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import first_jsp.DBConn;

public class PreparedStatementExam {
	private static Connection con;
	
	public static Connection getCon() throws SQLException, ClassNotFoundException{
		if(con==null){
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp", "root", "1234");
			con.setAutoCommit(false);
		}
		return con;
	}
	
	public static void closeCon() throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String args[]) {
		try {
			Connection con = DBConn.getCon();
			String sql = "insert into depart_table(depart_name) values(?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
 
			pstmt.setString(1, "디자인팀");
			pstmt.executeUpdate();
			pstmt.setString(1, "인사팀");
			pstmt.executeUpdate();
			pstmt.setString(1, "경영지원팀");
			pstmt.executeUpdate();
//			con.commit();
			
			DBConn.closeCon();
		
			
			int result = pstmt.executeUpdate();
			System.out.println("실행횟수 : " + result);
//			con.commit();
//			closeCon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}