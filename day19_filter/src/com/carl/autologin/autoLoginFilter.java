package com.carl.autologin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class autoLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		Cookie loginInfoCookie = null;
		Cookie cs[] = request.getCookies();
		for(int i=0; cs!=null&&i<cs.length;i++){
			if("logininfo".equals(cs[i].getName())){
				loginInfoCookie = cs[i];
				break;
			}
		}
		if(loginInfoCookie!=null){
			String usernamePassword = loginInfoCookie.getValue();
			
			String username = usernamePassword.split("\\_")[0];
			String cookiePassword = usernamePassword.split("\\_")[1];
			User user = UserDB.findUser(username);
			if(user!=null){
			if(cookiePassword.equals(MD5Util.md5(user.getPassword())));
				request.getSession().setAttribute("user", user);
			}
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
