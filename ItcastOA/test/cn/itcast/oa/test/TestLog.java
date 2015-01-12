package cn.itcast.oa.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {

	private static Log log = LogFactory.getLog(TestLog.class);
	
	@Test
	public void test(){
		log.debug("aaa");
		log.info("bbb");
		log.fatal("dfda");
		log.warn("dfadsf");
		log.error("fdasdf");
	}
}
