package com.test.ioc.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("desinger")

public class Designer implements Emp{

	
	public Work work;


	
	public void gotoOffice() {
		System.out.println("디자이너 출근");
		
	}
	
	public void getoffWork() {
		System.out.println("디자이너 퇴근");
		
	}
	

}
