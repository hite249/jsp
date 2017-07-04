package com.test.ioc.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.ioc.ch2.OrderManager;

public class DogApp {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dog.xml","dog_bean.xml"});
		DogManager dManager =(DogManager)context.getBean("dogManager");
		dManager.bark();

}
}
