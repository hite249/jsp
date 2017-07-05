package com.test.ioc.ch6;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.cglib.proxy.MethodProxy;



public class MyAroundAdvice{
	public void setAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("메소드 실행 전 안녕~");
		Object ref = pjp.proceed();
		System.out.println("메소드 실행 후  안녕~");
	}
	
}
