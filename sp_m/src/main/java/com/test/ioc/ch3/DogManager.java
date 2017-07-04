package com.test.ioc.ch3;

public class DogManager {
	private Puddle puddle;
	private Jindo jindo;
	
	public void setPuddle(Puddle puddle){
		this.puddle = puddle;
		
	}
	public void setJindo(Jindo jindo){
		this.jindo = jindo;
	}
	public void bark(){
		jindo.bark();
		puddle.bark();
	}
}
