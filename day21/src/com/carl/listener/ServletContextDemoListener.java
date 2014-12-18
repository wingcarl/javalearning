package com.carl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextDemoListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁了");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("创建了");

	}

}
