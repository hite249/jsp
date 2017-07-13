package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



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
		Scanner scan = new Scanner(System.in);
		
		System.out.println("2. 회원가입 선택");
		System.out.println("id?");
		String id = scan.next();
		user.setUser_id(id);
		
		System.out.println("password?");
		String pwd = scan.next();
		user.setUser_pwd(pwd);
		
		System.out.println("name?");
		String name = scan.next();
		user.setUser_name(name);
		
		System.out.println("class(숫자로 입력)?");
		String classnum = scan.next();
		user.setClass_num(Integer.parseInt(classnum));
		System.out.println("age(숫자로입력)?");
		String age = scan.next();
		user.setAge(Integer.parseInt(age));
		
		String sql = "insert into user_info(user_id, user_pwd, user_name, class_num, age)";
		sql += " values('" +  user.getUser_id()+ "', '" + user.getUser_pwd() + "', '" + user.getUser_name() + "', '" + user.getClass_num() + "', '" + user.getAge() + "')";

		PreparedStatement ps = con.prepareStatement(sql);
		int result = ps.executeUpdate(sql);
		
		return false;
	}
	@Override
	public boolean deleteUserInfo(User user) throws SQLException {
		Connection con =DBConn.getCon();
		Scanner scan = new Scanner(System.in);
		System.out.println("3. 회원 탈퇴선택");
		System.out.println("탈퇴하실 id?");
		String id = scan.next();
		user.setUser_id(id);
		
		System.out.println("탈퇴하실 password?");
		String pwd = scan.next();
		user.setUser_pwd(pwd);

		
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
