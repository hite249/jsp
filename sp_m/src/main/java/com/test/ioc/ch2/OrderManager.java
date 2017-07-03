package com.test.ioc.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {
	@Autowired
	@Qualifier("hyundai") //매칭되는 클래스가 한개일떄는 퀄리파이어가 없어도 오토와이어드 됨, 변수로 입력된 값이 선언된 값보다 우선
	private CarMaker maker;
	@Autowired
	@Qualifier("hyundai") //매칭되는 클래스가 한개일떄는 퀄리파이어가 없어도 오토와이어드 됨
	private CarMaker maker2;
	
	@Autowired
	private Money money;
	
	public OrderManager(){
		maker = new Kia();
		maker2 = new Samsung();
	}
	
	public void order(){
		Car car = maker.sell(new Money(100));
		Car car2 = maker2.sell(new Money(100));
	}
	public void setMaker(CarMaker maker){
		this.maker=maker;
	}
	
	
	}

