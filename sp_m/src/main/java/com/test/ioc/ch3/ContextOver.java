package com.test.ioc.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ContextOver {
	//father.xml String 클래스로 str1;
	//Son String 클래스로 str1;
	//Son Exam 클래스 target4
	//target4 setVal1(father의 str1
	//target4 setVal2(son의 str1)
	//출력하는 예제
	public static void main(String[] args) {
		GenericXmlApplicationContext father = new GenericXmlApplicationContext();
		father.load("father.xml");
		father.refresh();
		GenericXmlApplicationContext son = new GenericXmlApplicationContext();
		son.load("son.xml");
		son.setParent(father);
		son.refresh();
		Exam e = (Exam)son.getBean("target4");
		System.out.println(e.getVal1());
		System.out.println(e.getVal2());
	}

}
