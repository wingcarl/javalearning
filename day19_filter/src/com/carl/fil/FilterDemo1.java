package com.carl.fil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	//����ÿһ�ε��û����ʣ�������ø÷�����
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FilterDemo1����ǰ");
		chain.doFilter(request, response);//���У���Ŀ����Դִ��
		System.out.println("FilterDemo1���غ�");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilerDemo1��ʼ����");
	}
	public void destroy() {

	}

}
