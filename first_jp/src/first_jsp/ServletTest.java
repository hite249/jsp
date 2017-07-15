package first_jsp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implement.UserServiceImpl;
import service.UserService;

public class ServletTest extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String makething = request.getParameter("makething");
		int maxnum =Integer.parseInt(makething);
		String action = request.getParameter("action");
		String user_num = request.getParameter("user_num");
		String result = "";

		HttpSession session = request.getSession();
		if(action.equals("MAKETHING")){
			for(int i=1;i<=maxnum;i++){
				result +="<td><input type='text' />";
				
			}
		}else {
			System.out.println("dd");
		}
	}
}
