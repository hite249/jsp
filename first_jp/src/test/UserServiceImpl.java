package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



public class UserServiceImpl implements UserService{

	
	
	@Override
	public ArrayList<HashMap> selectUserInfo(User user) throws SQLException {
		Connection con = DBConn.getCon();
				ArrayList<HashMap> userInfoList = new ArrayList<HashMap>();
		String sql = "select user_num, user_id, user_pwd, user_name, class_num, age from user_info";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCnt = rsmd.getColumnCount();
		while (rs.next()) {
			HashMap hm = new HashMap();
			for (int i = 1; i <= colCnt; i++) {
				String name = rsmd.getColumnLabel(i);
				hm.put(name, rs.getString(name));
			}
			userInfoList.add(hm);
		}
		return userInfoList;
		
	}
	@Override
	public boolean insertUserInfo(User user) throws SQLException{
		Connection con = DBConn.getCon();
		String sql = "insert into user_info(user_id, user_pwd, user_name, class_num, age)";
		sql += " values('" +  user.getUser_id()+ "', '" + user.getUser_pwd() + "', '" + user.getUser_name() + "', '" + user.getClass_num() + "', '" + user.getAge() + "')";

		PreparedStatement ps = con.prepareStatement(sql);
		int result = ps.executeUpdate(sql);
		
		return false;
	}
	@Override
	public boolean deleteUserInfo(User user) throws SQLException {
		Connection con =DBConn.getCon();
		
		try {
			String sql = "delete from user_info";
			sql += " where user_id='" + user.getUser_id() + "' and user_pwd='" + user.getUser_pwd() + "'";

			PreparedStatement ps = con.prepareStatement(sql);
			int result = ps.executeUpdate();
			System.out.println("탈퇴 완료");
		} catch (Exception e) {
			System.out.println("ID와 PASSWORD가 일치하지 않습니다.");
		}
		return false;

	}
	




	
			
	
}
