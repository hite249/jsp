package com.test.ioc.ch2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("work")
public class Work {
	
//	@Autowired
//	List<Emp> empList;
////	public Work(){
////		empList = new ArrayList<Emp>();
////		empList.add(new Designer());
////		empList.add(new Programmer());
////	}
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ioc2.xml");
		
		Working dev = (Working)context.getBean("working");
		dev.work();
//		Work w = new Work();
		
	
			
		}
		
	}

