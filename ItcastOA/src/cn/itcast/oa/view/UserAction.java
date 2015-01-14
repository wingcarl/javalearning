package cn.itcast.oa.view;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	private Long departmentId;
	private Long[] roleIds;
	/**
	 * 列表页面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	/**
	 * 删除，完成之后转到列表页面
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		userService.delete(model.getId());
		return "toList";
	}
	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		List<Role> roleList = roleService.findAll();
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, null);
		ActionContext.getContext().put("roleList", roleList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "addUI";
	}
	/**
	 * 添加，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		Department department = departmentService.getById(departmentId);
		model.setDepartment(department);
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		userService.add(model);
		return "toList";
	}
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		List<Role> roleList = roleService.findAll();
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, null);
		ActionContext.getContext().put("roleList", roleList);
		ActionContext.getContext().put("departmentList", departmentList);
		User user = new User();
		user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if(user.getDepartment()!= null){
			departmentId = user.getDepartment().getId();
		}
		if(user.getRoles()!=null){
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		return "editUI";
	}
	/**
	 * 修改，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		User user = userService.getById(model.getId());
		// 2，设置要修改的属性
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		// >> 处理关联的一个部门
		user.setDepartment(departmentService.getById(departmentId));
		// >> 处理关联的多个岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		userService.update(user);
		return "toList";
	}
	
	public String initPassword() throws Exception{
		User user = userService.getById(model.getId());
		String md5 = DigestUtils.md5Hex("1234"); // 密码要使用MD5摘要
		user.setPassword(md5);
		userService.update(user);
		return "toList";
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	
	
}
