package com.carl.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {

	public static <T>T fillBean(HttpServletRequest request,Class<T> clazz){
		try {
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e){
			throw new RuntimeException();
		}
		
	}
}
