package com.carl.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class AllCharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//��ȡ���õĹ���������encoding��ֵ�����û�У�����һ��Ĭ��ֵ
		String encoding = filterConfig.getInitParameter("encoding");
		if(encoding==null)
			encoding = "UTF-8";
		//����POST����ʽ��������������ı���
		request.setCharacterEncoding(encoding);
		//������Ӧ���ʱ�ı��룺�ַ������ֽ���
		response.setCharacterEncoding(encoding);//�ֽ������ʱ֪ͨ�ͻ��˵Ľ������
		response.setContentType("text/html;charset="+encoding);//�ֽ������ʱ֪ͨ�ͻ��˵Ľ�������ַ������ַ������ʱʹ�õ����֪ͨ�ͻ��˽����õ����
		
		MyHttpServletRequest mrequest = new MyHttpServletRequest(request);
		//����
		chain.doFilter(mrequest, response);
	}

	
	public void destroy() {

	}
}

//HttpServletRequestWrapper�ڲ��Ĵ��������ӳ�ԭ�����Ǹ�Ĭ��������һ��
class MyHttpServletRequest extends HttpServletRequestWrapper{
	public MyHttpServletRequest(HttpServletRequest request){
		super(request);
	}
	//ֻ��get����ʽ���и�д
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null)
			return value;
		//�õ�����ʽ
		String method = super.getMethod();
		if("get".equalsIgnoreCase(method)){
			try {
				value = new String(value.getBytes("ISO-8859-1"),super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
}
//class MyHttpServletRequest extends HttpServletRequestWrapper{
//	private HttpServletRequest request;
//	public MyHttpServletRequest(HttpServletRequest request){
//		super(request);
//		this.request = request;
//	}
//	//ֻ��get����ʽ���и�д
//	public String getParameter(String name) {
//		String value = request.getParameter(name);
//		if(value==null)
//			return value;
//		//�õ�����ʽ
//		String method = request.getMethod();
//		if("get".equalsIgnoreCase(method)){
//			try {
//				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		return value;
//	}
//	
//}