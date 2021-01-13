package com.gao.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    /**
     * AOP自动装配方式
     */
    @Test
    public void testAop(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
        System.out.println("获取的bean是代理类..."+arithmeticCalculator.getClass().getName());
        arithmeticCalculator.add(11, 12);
//        arithmeticCalculator.div(21, 0);
    }

}