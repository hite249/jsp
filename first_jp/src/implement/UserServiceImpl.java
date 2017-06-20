package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import first_jsp.DBConn;
import first_jsp.User;
import service.UserService;

 
public class UserServiceImpl implements UserService {
 
	public User login(String userId, String userPwd) {
		User user = null;
		try {
			Connection con = DBConn.getCon();
			String sql = "select age, user_pwd, user_name, user_num, admin, board_admin from user_info where user_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
 
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (userPwd.equals(rs.getString("user_pwd"))) {
					user = new User();
					user.setUser_id(userId);
					user.setUser_name(rs.getString("user_name"));
					user.setUser_num(rs.getInt("user_num"));
					user.setAdmin(rs.getInt("admin"));
					user.setAge(rs.getInt("age"));
					user.setBoard_admin(rs.getInt("board_admin"));
					user.setUser_pwd(rs.getString("user_pwd"));
					return user;
				}
				DBConn.closeCon();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
 
	@Override
	public boolean signup(User user) {
		try {
			Connection con = DBConn.getCon();
			String sql = "insert into user_info(user_id, user_pwd, user_name, age) values(?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pwd());
			pstmt.setString(3, user.getUser_name());
			pstmt.setInt(4, user.getAge());
 
			int resultNum = pstmt.executeUpdate();
			if (resultNum == 1) {
				return true;
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
 
	@Override
	public boolean logout(HttpSession session) {
		try{
			session.invalidate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean signout(User user) {
		
		try {
			Connection con = DBConn.getCon();
			String sql = "delete from user_info where user_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_num());
			int result=pstmt.executeUpdate();
			if(result==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
			
		
		
	}
	

	

	@Override
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		
		
		try {
			Connection con = DBConn.getCon();
			String sql = "select user_id, age, user_pwd, user_name, user_num, admin, board_admin from user_info";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
 			while (rs.next()) {
				
					User user= new User();
					user.setUser_id(rs.getString("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_num(rs.getInt("user_num"));
					user.setAdmin(rs.getInt("admin"));
					user.setAge(rs.getInt("age"));
					user.setBoard_admin(rs.getInt("board_admin"));
					user.setUser_pwd(rs.getString("user_pwd"));
				
						userList.add(user);
				
				}
				DBConn.closeCon();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
		
	
	

 
}