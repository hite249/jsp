package com.test.ioc.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("programmer") //서비스 뒤의 (" ")은 생략가능하다.

public class Programmer implements Emp{


	public Work work;


	public void gotoOffice() {
		// TODO Auto-generated method stub
		System.out.println("출근을 합니다.");
	}


	public void getoffWork() {
		// TODO Auto-generated method stub
		System.out.println("퇴근을 합니다.");
	}
	public static void main(String[] args){
		Programmer p=new Programmer();
		Working w = new Working(p);
		w.work();
	
	}

	}
	


