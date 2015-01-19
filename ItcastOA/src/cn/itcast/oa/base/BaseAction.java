package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.ForumService;
import cn.itcast.oa.service.PrivilegeService;
import cn.itcast.oa.service.ReplyService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.TopicService;
import cn.itcast.oa.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;

	protected T model ;
	@SuppressWarnings("unchecked")
	public BaseAction(){
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>)pt.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		} 
	}
	
	@Override
	public T getModel() {
		return model;
	}

	/**
	 * 返回当前session中存储的用户
	 * @return
	 */
	protected User getUser(){
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	/**
	 * 返回客户端的IP地址
	 * @return
	 */
	protected String getIpAddr(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}
}
