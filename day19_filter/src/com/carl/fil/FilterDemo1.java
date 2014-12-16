package com.carl.fil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	//对于每一次的用户访问，都会调用该方法。
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FilterDemo1拦截前");
		chain.doFilter(request, response);//放行，让目标资源执行
		System.out.println("FilterDemo1拦截后");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilerDemo1初始化了");
	}
	public void destroy() {

	}

}
