package com.carl.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
//È«Õ¾Ñ¹Ëõ¹ýÂËÆ÷
public class GZipFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		GZipHttpServletResponse gresponse = new GZipHttpServletResponse(response);
		arg2.doFilter(request, gresponse);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(baos);
		byte b[] = gresponse.getOldBytes();
		System.out.println("old"+b.length);
		gout.write(b);
		gout.close();
		b = baos.toByteArray();
		System.out.println("new"+b.length);
		response.setHeader("Content-Encoding", "gzip");
		response.setContentLength(b.length);
		ServletOutputStream out = response.getOutputStream();
		out.write(b);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
class GZipHttpServletResponse extends HttpServletResponseWrapper{

	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	public GZipHttpServletResponse(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return new MyServletOutputStream(baos);
	}
	public byte[] getOldBytes(){
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();
	}
}
class MyServletOutputStream extends ServletOutputStream{

	private ByteArrayOutputStream baos;
	public MyServletOutputStream(ByteArrayOutputStream baos) {
		this.baos = baos;
	}
	
	@Override
	public void write(int b) throws IOException {
		baos.write(b);
	}
}
