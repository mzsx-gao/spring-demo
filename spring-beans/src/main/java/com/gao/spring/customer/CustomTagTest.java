package com.gao.spring.customer;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTagTest {

	@Test
	public void helloworld(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-customer.xml");
        SimpleDateFormat info = (SimpleDateFormat) ctx.getBean("dateFormat");
        System.out.println(info.format(new Date()));
    }

}
