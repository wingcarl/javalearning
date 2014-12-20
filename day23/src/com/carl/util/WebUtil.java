package com.carl.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	public static <T>T fillBean(HttpServletRequest request,Class<T> clazz){
		try {
			T t = clazz.newInstance();// 调用默认构造方法创建对象
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
