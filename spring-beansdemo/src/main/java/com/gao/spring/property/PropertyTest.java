package com.gao.spring.property;


import com.gao.spring.event.MsgEvent;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyTest {

	@Test
	public void helloworld(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("property.xml");
        Property helloWorld = (Property) ctx.getBean("property");
        System.out.println(helloWorld);
    }

    @Test
    public void testListener(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("property.xml");
        MsgEvent event = new MsgEvent("hello,testListener","内容");
        ctx.publishEvent(event);
    }


}
