package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import first_jsp.DBConn;
import first_jsp.User;

public class LoginService {

	public User login(String userId, String userPwd){
		User user = null;
		try {
			Connection con = DBConn.getCon();
			String sql = "select user_id, user_pwd,user_name from user_info where user_id=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
 
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				if(userPwd.equals(rs.getString("user_pwd"))){
					user = new User();
					user.setUser_id(userId);
					user.setUser_name(rs.getString("user_name"));
					return user;
				}	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return user;
	}
}