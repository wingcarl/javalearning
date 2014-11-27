package com.carl.base.introspector;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class Demo2 {

	@Test
	public void test1() throws Exception{
		Map map = new HashMap();
		map.put("name", "Vika");
		map.put("age", "21");
		map.put("birthday", "1993-1-3");
		Person p = new Person();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(p, map);
		System.out.println(p);
	}
}
