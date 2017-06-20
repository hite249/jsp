package first_jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test {
	public static String makeSql(User user){
		String sql ="select ut.user_num, ut.user_name, ut.depart_num, dt.depart_name from user_table ut, depart_table dt ";
		sql +=" where ut.depart_num=dt.depart_num";
		
		
		if(user.getUserName()!=null){
			sql +=" and ut.user_name =?";
			
		}else{
			
		}
		if(user.getUserNum()!=0){
			sql +=" and ut.user_num =?";
			
		}else{
			
		}
		if(user.getDepartName()!=null){
			sql +=" and dt.depart_name=?";
		}else{
			
		}
		if(user.getDepartNum()!=0){
			sql +=" and dt.depart_num=?";
		}else{
			
		}
		return sql;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); //mysql드라이버 호출
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp","root","1234");
			con.setAutoCommit(false);
			User user = new User();
			user.setDepartName("전산팀");
			user.setDepartNum(1);
			user.setUserName("홍길동");
			user.setUserName("홍길동");
			String sql = makeSql(user);
			System.out.println(sql);
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setInt(1, user.getDepartNum());
			stmt.setInt(1, user.getDepartNum());
			stmt.setInt(1, user.getDepartNum());
			stmt.setInt(1, user.getDepartNum());
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				User u = new User();
				u.setUserNum(rs.getInt("user_num"));
				u.setUserName(rs.getString("user_name"));
				u.setDepartNum(rs.getInt("depart_num"));
				u.setDepartName(rs.getString("depart_name"));
				
				System.out.println(u.getUserName());
			}
			
			con.commit();
			con.close();
			
		} catch(Exception e){
			System.out.println(e);
		}
	}
}
			
			
			
			//Statement stmt1 = con.createStatement();
			
//			String sql ="select ut.user_num, ut.user_name, ut.depart_num, dt.depart_name from user_table ut, depart_table dt ";
//			sql +=" where ut.depart_num=dt.depart_num";
//			
//			if(user.getUserName()!=null){
//				sql +=" and ut.user_name ='"+user.getUserName()+"'";
//			}else{
//				
//			}
//			if(user.getUserNum()!=0){
//				sql +=" and ut.user_num="+ user.getUserNum();
//			}else{
//				
//			}
			/*ResultSet rs = stmt.executeQuery("select ut.user_num, ut.user_name, ut.depart_num, dt.depart_name"
					+ " from user_table ut, depart_table dt "
					+ "where ut.depart_num=dt.depart_num"
					+ "and ut.user_name='"+user.getUserName()+"'";
					);*/

//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()){
//				User u = new User();
//				u.setUserNum(rs.getInt("userNum"));
//				u.setUserName(rs.getString("userName"));
//				u.setDepartNum(rs.getInt("DepartNum"));
//				u.setDepartName(rs.getString("DepartName"));
//				
//				System.out.println(u);
//			}
//			
			// equals와 == 
			
			// staement prepare statement
			
			
			
			/* user_num int
			 * user_name string
			 * depart_num int
			 * depart_name string 
			 */
			
//			//int result = 0;
//			while(rs.next()){
//				String sql ="select ui.user_num, ui.user_name, ui.user_id, ui.user_pwd, ui.user_pwd, ci.class_num, ci,class_name from user_info as ui, class_info as ci where ui.user_num=ci.user_num";
//				for(int i=0,max=5;i<max;i++){
//					result +=stmt.executeUpdate(sql);
//
//				/*
//				 int userNum=rs.getInt(1);
//				 
//				String sql = "insert into class_info(class_name, user_num) values('c1',"+userNum+")";
//				System.out.println(sql);
//				result +=stmt1.executeUpdate(sql);*/
//			}
//			con.commit();
//			con.close();
//			
//			
//			
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//
//	}
//	public static void searchUser


/*int result = 0;
String sql ="insert into class_info(class_name, user_num) values('jsp_study','1')";
for(int i=0,max=5;i<max;i++){
	result +=stmt.executeUpdate(sql);
	
	con.commit();
}
*/