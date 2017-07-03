package com.test.ioc.ch2;

import org.springframework.stereotype.Component;

@Component("car") //dto클래스를 지칭하는 것이 component 어노테이션
public class Car {
	private String name;
	public Car(){}
	public Car(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
