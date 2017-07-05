package com.test.ioc.ch5;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;



public class MyAroundAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("메소드 실행전 hello...");
		Object ref = invocation.proceed();
		System.out.println("메소드 실행후 hello...");
		return ref;
	}

	

}
