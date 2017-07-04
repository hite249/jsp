package com.test.ioc.ch3;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;



public class Designer implements MethodReplacer{

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		return "디자이너 일해요~";
	}
	
}
	