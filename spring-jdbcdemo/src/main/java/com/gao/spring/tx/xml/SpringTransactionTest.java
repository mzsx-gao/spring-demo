package com.gao.spring.tx.xml;

import java.util.Arrays;

import com.gao.spring.tx.xml.service.BookShopService;
import com.gao.spring.tx.xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTransactionTest {

	private ApplicationContext ctx;
	private BookShopService bookShopService;
	private Cashier cashier;
	
	{
		ctx = new ClassPathXmlApplicationContext("spring-tx-xml.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	
}
