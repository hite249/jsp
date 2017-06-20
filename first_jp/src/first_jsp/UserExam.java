package first_jsp;

public class UserExam {
	public static void main(String[] args){
		User u = new User();
		u.setUserName("홍길동");
		u.setUserNum(2);
		u.setDepartNum(1);
		u.setDepartName("관리부");
		
		System.out.println("이름: "+u.getUserName());
		System.out.println("유저번호: "+u.getUserNum());
		System.out.println("부서번호: "+u.getDepartNum());
		System.out.println("부서이름: "+u.getDepartName());
	}

}
