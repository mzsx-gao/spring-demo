package com.gao.spring.aop.helloWorld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@Test
	public void helloworld(){
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);

		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
	}

	//使用jdk动态代理实现
	@Test
	public void jdkProxy(){
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
	    ArithmeticCalculatorLoggingProxy proxy = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator);
        ArithmeticCalculator cal = proxy.getLoggingProxy();
        int result = cal.add(11, 12);
        System.out.println("result:" + result);

        result = cal.div(21, 3);
        System.out.println("result:" + result);
    }

    @Test
    public void testAop(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName());

        arithmeticCalculator.add(11, 12);

//        arithmeticCalculator.div(21, 0);
    }

}
