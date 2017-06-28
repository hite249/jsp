package com.test.ioc.ch2;

public class OrderManger {
	private Maker maker;
	
	public OrderManger(){
		this.maker = new Samsung();
	}
	
	public void order(){
		Car car = maker.sell(new Money(100));
	}
	public void setMaker(Maker maker){
		this.maker=maker;
	}
	
	
}
