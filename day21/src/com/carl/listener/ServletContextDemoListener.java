package com.carl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextDemoListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("������");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("������");

	}

}
