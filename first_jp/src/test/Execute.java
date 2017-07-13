package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Execute {
	Connection con;
	PreparedStatement ps;

	Execute() {
		try {
			con = DBConn.getCon();
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUserInfo() throws SQLException {
		String sql = "update user_info";
		sql += " set user_name='흑길동'";
		sql += " where user_num=6";

		ps = con.prepareStatement(sql);
		int result = ps.executeUpdate();
		System.out.println(result + "갯수 만큼 수정 되었습니다.");
	}
	
	public static void main(String[] args) throws SQLException {
		UserService us = new UserServiceImpl();
		User user = new User();
		Execute ec = new Execute();

		Scanner scan = new Scanner(System.in);
		System.out.println("사용하실 서비스번호를 입력해주세요.");
		System.out.println("1. 유저리스트");
		System.out.println("2. 회원가입");
		System.out.println("3. 회원탈퇴");

		int command = Integer.parseInt(scan.nextLine());
		if (command == 1) {
			System.out.println("1. 유저리스트 선택");
			try {

				ArrayList<HashMap> userInfoList = us.selectUserInfo(user);
				for (HashMap hm : userInfoList) {
					System.out.println(hm);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command == 2) {
		
			us.insertUserInfo(user);

			System.out.println(user.getUser_name() + "님 가입완료~!!");

		} else if (command == 3) {

			us.deleteUserInfo(user);

		} else {
			System.out.println("서비스번호를 잘못 입력하셨습니다.");
		}
	}
}
