package com.test.ioc.ch3;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Jindo implements Dog{
	public void bark(){
		System.out.println("멍멍");
	}

}
