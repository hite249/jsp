package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import first_jsp.DBConn;
import first_jsp.User;

public class SignupService {

	public boolean signup(User user){
		
		try {
			Connection con = DBConn.getCon();
			String sql = "insert into user_info (user_name, user_id,user_pwd, age)";
			sql +=" values(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_id());
			pstmt.setString(3, user.getUser_pwd());
			pstmt.setInt(4, user.getAge());
			
			int resultNum = pstmt.executeUpdate();
			if(resultNum==1){
				return true;
				}	
			
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}finally{
			try{
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
}