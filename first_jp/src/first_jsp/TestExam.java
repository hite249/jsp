package first_jsp;

public class TestExam {
	
	public static String makeStr(TestEntity te){
		String str="나의 취미는 ";
		if(te.getMyHobby()!=null){
			str += te.getMyHobby() +" 입니다.";
		}else{
			str +="없습니다.";
		}
		str +="그리고 나의 이름은";
		if(te.getMyName()!=null){
			str +=te.getMyName()+"입니다.";
		}else{
			str +="무명입니다.";
		}
		return str;
	}
	
	public static void main (String[] args){
		TestEntity te = new TestEntity();
		te.setMyName("홍길동");
		te.setMyHobby("게임");
		String str = makeStr(te);
		System.out.println(str);
	}

}
