package cn.itcast.oa.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

public class OAInitListener implements ServletContextListener{

	private Log log = LogFactory.getLog(OAInitListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(application);
		PrivilegeService privilegeService = (PrivilegeService) ac
				.getBean("privilegeServiceImpl");
		// 查询出所有的顶级权限信息
		List<Privilege> privilegeTopList = privilegeService.findTopList();
		application.setAttribute("privilegeTopList", privilegeTopList);
		log.info("===已经初始化权限列表===");
		// 查询出所有权限信息的URL
		List<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		log.info("===已经初始化权限url===");
	}

}
