package com.test.ioc.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("kia")
public class Kia implements CarMaker{
	@Autowired
	private Car car;

	public Kia(){}
	public Car sell(Money money){
		System.out.println("기아차팔았다!");
		Car car = new Car("k9");
		return car;
	}
}
