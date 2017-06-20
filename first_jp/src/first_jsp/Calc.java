package first_jsp;


public class Calc {
	
	public int executeResult(String operator, int num1, int num2){
		int result = 0;
		if("+".equals(operator)){
			result = getPlus(num1,num2);
		}else if("+".equals(operator)){
			result = getPlus(num1,num2);
		}else if("-".equals(operator)){
			result = getMinus(num1,num2);
		}else if("/".equals(operator)){
			result = getDivide(num1,num2);
		}else if("*".equals(operator)){
			result = getMultiple(num1,num2);
		}
		return result;
	}
	public int getPlus(int num1, int num2){
		return num1 + num2;
	}
	public int getMinus(int num1, int num2){
		return num1 - num2;
	}
	public int getMultiple(int num1, int num2){
		return num1*num2;
	}
	public int getDivide(int num1, int num2){
		return num1/num2;
	}
}