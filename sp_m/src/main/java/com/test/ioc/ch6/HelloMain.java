package com.test.ioc.ch6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc10.xml");
		IPrintMsg printMsg = (IPrintMsg) ctx.getBean("printMsg");
		printMsg.hello1();
		printMsg.hello2();
	}

}
