package cn.itcast.oa.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class TestAction extends ActionSupport{

	@Resource
	private TestService testService;
	@Override
	public String execute() throws Exception {
		System.out.println("===========>TestAction.execute()");
		return SUCCESS;
	}
	
}
