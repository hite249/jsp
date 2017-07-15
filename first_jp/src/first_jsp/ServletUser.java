package first_jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implement.UserServiceImpl;
import service.UserService;

public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String action = request.getParameter("action");
		String user_num = request.getParameter("user_num");
		String result = "";

		HttpSession session = request.getSession();
		if (action.equals("LOGIN")) {

			User user = us.login(id, pwd);
			if (user != null) {

				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
				session.setAttribute("name", user.getUser_name());
				session.setAttribute("admin", user.getAdmin());
				session.setAttribute("board_admin", user.getBoard_admin());
				result += id + "님 로그인에 성공 하셨습니다.<input type='button' value='logout'onclick='doLogout()'/>";
				result += "<br/><input type='button' value='게시판불러오기' onclick='doGetBoardList()'/>";
				String aa = request.getParameter("id");
				result +="<br/>";
				result +="id :";
				result += aa+"<br/>";
				if (user.getAdmin() == 1) {
					result += "<br/><input type='button' value='유저리스트불러오기' onclick='doGetUserList()'/>";
				}


		} else {
			result += id + "님 로그인에 실패 하셨습니다.";
		}
	}else if(action.equals("SIGNUP")){
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		User user = new User();
		user.setUser_name(name);
		user.setUser_id(id);
		user.setUser_pwd(pwd);
		user.setAge((Integer.parseInt(age)));
		boolean isInsert = us.signup(user);
		if (isInsert) {
			result += id + "회원가입 성공";
		} else {
			result += id + "회원가입 실패";

		}

	}else if(action.equals("LOGOUT"))
	{
		id = (String) session.getAttribute("id");
		us.logout(session);
		result = id + "님 로그아웃";
		session.invalidate();
	}else if(action.equals("USERLIST"))
	{
		int admin = (int) session.getAttribute("admin");
		if (admin == 1) {
			List<User> userList = us.getUserList();
			result += "<table border='1'>";
			result += "<tr>";
			result += "<td>유저번호</td>";
			result += "<td>유저아이디</td>";
			result += "<td>유저이름</td>";
			result += "<td>유저나이</td>";
			result += "<td>회원탈퇴</td>";
			result += "</tr>";
			for (User u : userList) {
				result += "<tr>";
				result += "<td>" + u.getUser_num() + "</td>";
				result += "<td>" + u.getUser_id() + "</td>";
				result += "<td>" + u.getUser_name() + "</td>";
				result += "<td>" + u.getAge() + "</td>";
				result += "<td><input type='button' value='탈퇴하기' onclick='doSignout(" + u.getUser_num() + ")'/>";
				result += "</tr>";
			}
			result += "</table border>";
		} else {
			result = "권한없음";

		}

	}else if(action.equals("SIGNOUT"))
	{
		int admin = (int) session.getAttribute("admin");
		if (admin == 1) {
			String userNum = request.getParameter("user_num");
			User user = new User();
			user.setUser_num((Integer.parseInt(userNum)));
			us.signout(user);
			result = "탈퇴성공";
		} else {
			result = "권한 없음";
		}
	}else if(action.equals("LOGIN11"))
	{
		
		
//		String aa = request.getParameter("id");
		
		result +="id :";
		result += "<br/>";
//		result +="aa :"+aa+"<br/>";
		
		result +="hello";
//		for(int i=1;i<=maxnum;i++){
//			result +="<input type='text'/>";
//		}
		
	}

	resp.setContentType("text/html; charset = UTF-8");
	PrintWriter pw = resp.getWriter();pw.println(result);

}

public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	// String writeStr ="";
	//// UserController ul = new UserController(req);
	//// writeStr = ul.doAction();
	// doProcess(resp,writeStr);
}

	public void doProcess(HttpServletResponse resp, String writeStr) throws IOException {
		// resp.setContentType("text/html; charset = UTF-8");
		//
		// PrintWriter out1 = resp.getWriter();
		// out1.println(writeStr);
	}
}
