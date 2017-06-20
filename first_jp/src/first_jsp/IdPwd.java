package first_jsp;
public class IdPwd {
	public static String getIdNPwd(String id, String pwd){
		String result="";
		for(int i=1;i<=10;i++){
			result +=i+"."+id+","+pwd+"\n";
		}
		return result;
	}
	public static void main(String[] args){
		String id="id";
		String pwd="pwd";
		
		String result =getIdNPwd(id,pwd);
		System.out.println(result);
	}


}
