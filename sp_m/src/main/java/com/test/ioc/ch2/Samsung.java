package com.test.ioc.ch2;

public class Samsung implements Maker{

	public Samsung(){}
	public Car sell(Money money){
		System.out.println("삼성차팔았다!");
		Car car = new Car("SM6");
		return car;
	}
}
