package first_jsp;

public class Parameter {
	
	static String str;
	
	public static void setStr(String str){
		Parameter.str=str;
		
	}
	public static String getStr(){
		return Parameter.str;
	}
	public static void main(String[] args){
		String str=getStr();
		
		try{
			str.toUpperCase();
		}catch(Exception e){
			System.out.println("bye~");
		}
	}
}
