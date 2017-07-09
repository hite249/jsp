package test;

import java.util.Scanner;

public class Execute {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("사용하실 서비스번호를 입력해주세요.");
		System.out.println("1. 유저리스트");
		System.out.println("2. 회원가입");
		System.out.println("3. 회원탈퇴");
		
		int command = Integer.parseInt(scan.nextLine());
		if(command==1){
			
		}else if(command==2){
			
		}else if(command==3){
			
		}else{
			System.out.println("서비스번호를 잘못 입력하셨습니다.");
		}
	}
}


