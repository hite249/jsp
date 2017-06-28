package com.test.ioc.ch1;

public class Hyundai {

	public Hyundai(){}
	public Car sell(Money money){
		System.out.println("현대차팔았다!");
		Car car = new Car("YF소나타");
		return car;
	}
}
