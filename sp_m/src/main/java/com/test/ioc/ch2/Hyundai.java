package com.test.ioc.ch2;

public class Hyundai implements Maker{

	public Hyundai(){}
	public Car sell(Money money){
		System.out.println("현대차팔았다!");
		Car car = new Car("YF소나타");
		return car;
	}
}
