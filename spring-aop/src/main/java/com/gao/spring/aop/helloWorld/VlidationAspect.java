package com.gao.spring.aop.helloWorld;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
@Order(1)
@Aspect
@Component
public class VlidationAspect {

	@Before("com.gao.spring.aop.helloWorld.LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
	}
	
}
