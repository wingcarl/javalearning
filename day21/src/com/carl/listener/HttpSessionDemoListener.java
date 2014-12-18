package com.carl.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionDemoListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println(session+"被创建了");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println(session+"被销毁了");
		
	}

}
