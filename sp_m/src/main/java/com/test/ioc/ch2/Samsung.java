package com.test.ioc.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("samsung")
public class Samsung implements CarMaker{
	@Autowired
	private Car car;
	public Samsung(){}
	public Car sell(Money money){
		System.out.println("삼성차팔았다!");
		Car car = new Car("SM6");
		return car;
	}
}
