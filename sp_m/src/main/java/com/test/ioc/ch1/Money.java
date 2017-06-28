package com.test.ioc.ch1;

public class Money {
	private int amt;
	public Money(){}
	public Money(int amt){
		this.amt = amt;
	}
	
	public int getAmt(){
		return this.amt;
	}
	
	public void setAmt(int amt){
		this.amt = amt;
	}
}
