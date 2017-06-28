package com.test.ioc.ch2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {

	public static void main(String[] args){
		FileSystemResource fsr = new FileSystemResource("src/main/resources/ioc3.xml");
		BeanFactory factory = new XmlBeanFactory(fsr);
		OrderManger manager = (OrderManger)factory.getBean("orderManager");
		manager.order();
	}
}
