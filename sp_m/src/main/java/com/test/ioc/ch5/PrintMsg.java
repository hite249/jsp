package com.test.ioc.ch5;

public class PrintMsg implements IPrintMsg{

	@Override
	public void hello() {
		System.out.println("hello~");
		
	}

	@Override
	public void hello1() {
		System.out.println("hello~1");
		
	}

	@Override
	public void hello2() {
		System.out.println("hello~2");
		
	}
	

}
