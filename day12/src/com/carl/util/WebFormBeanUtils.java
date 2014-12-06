package com.carl.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.carl.web.controller.RegistFormBean;

public class WebFormBeanUtils {

	public static <T>T fillFormBean(HttpServletRequest request,Class<T> clz){
		try {
			T bean = clz.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
