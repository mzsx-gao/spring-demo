package com.gao.servlet3.other;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//监听项目的启动或停止
public class OrderListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.err.println("OrderListener...contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		System.err.println("OrderListener...contextInitialized");
		
	}

}
