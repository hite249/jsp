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
	Execute(){
		try{
			con = DBConn.getCon();
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<HashMap> selectUserInfo() throws SQLException{
		ArrayList<HashMap> userInfoList = new ArrayList<HashMap>();
		String sql = "select user_num, user_id, user_pwd, user_name, class_num, age from user_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCnt = rsmd.getColumnCount();
		while(rs.next()){
			HashMap hm = new HashMap();
			for(int i=1;i<=colCnt;i++){
				String name = rsmd.getColumnLabel(i);
				hm.put(name, rs.getString(name));
			}
			userInfoList.add(hm);
		}
		return userInfoList;
	}
	
	public void deleteUserInfo(){
		String sql = "delete from user_info";
	}
	
	public void updateUserInfo() throws SQLException{
		String sql = "update user_info";
		sql += " set user_name='흑길동'";
		sql += " where user_num=6";

		ps = con.prepareStatement(sql);
		int result = ps.executeUpdate();
		System.out.println(result + "갯수 만큼 수정 되었습니다.");
	}
	
	public void insertUserInfo(){
		String sql = "insert into user_info(user_id, user_pwd, user_name, class_num, age)";
	}

	
	
	public static void main(String[] args){
		
		try {
			Execute ec = new Execute();
			ArrayList<HashMap> userInfoList = ec.selectUserInfo();
			for(HashMap hm : userInfoList){
				System.out.println(hm);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("사용하실 서비스번호를 입력해주세요.");
		System.out.println("1. 유저리스트");
		System.out.println("2. 회원가입");
		System.out.println("3. 회원탈퇴");
		
		int command = Integer.parseInt(scan.nextLine());
		if(command==1){
			System.out.println("1");
			ec.
		}else if(command==2){
			System.out.println("2");
		}else if(command==3){
			System.out.println("3");
		}else{
			System.out.println("서비스번호를 잘못 입력하셨습니다.");
		}
	}
}


