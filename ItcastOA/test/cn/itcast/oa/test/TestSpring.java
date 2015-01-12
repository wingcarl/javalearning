package cn.itcast.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testSessionFactory() throws Exception{
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		System.out.println(sf.openSession());
	}
	
	@Test
	public void tesTx() throws Exception{
		TestService service = (TestService)ac.getBean("testService");
		service.saveTwoUsers();
	}
	
	@Test
	public void testAction() throws Exception{
		TestAction action = (TestAction)ac.getBean("testAction");
		System.out.println(action);
	}
}
