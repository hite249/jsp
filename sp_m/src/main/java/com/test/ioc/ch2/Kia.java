package com.test.ioc.ch2;

public class Kia implements Maker{

	public Kia(){}
	public Car sell(Money money){
		System.out.println("기아차팔았다!");
		Car car = new Car("k9");
		return car;
	}
}
