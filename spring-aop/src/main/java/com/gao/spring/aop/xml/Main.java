package com.gao.spring.aop.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test
    public void testAop(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName());

        arithmeticCalculator.add(11, 12);

//        arithmeticCalculator.div(21, 0);
    }

}
