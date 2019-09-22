package com.gao.spring.event;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 事件监听的用法
 * @Auther: gaoshudian
 * @Date: 2019/9/5 21:27
 */
public class EventTest {

    @Test
    public void helloworld(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("property.xml");
        MsgEvent msgEvent = new MsgEvent("hello","消息");
        ctx.publishEvent(msgEvent);
    }
}
