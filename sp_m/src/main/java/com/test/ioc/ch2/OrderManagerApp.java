package com.test.ioc.ch2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {


	public static void main(String[] args){
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc2.xml");
		OrderManager om =(OrderManager)factory.getBean("orderManager");
		om.order();
		
	}
}
