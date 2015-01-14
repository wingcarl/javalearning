package cn.itcast.oa.view;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	private Long[] privilegeIds;
	
	/**
	 * 列表页面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	/**
	 * 删除，完成之后转到列表页面
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		roleService.delete(model.getId());
		return "toList";
	}
	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		return "addUI";
	}
	/**
	 * 添加，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		roleService.add(model);
		return "toList";
	}
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		Role role = new Role();
		role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI";
	}
	/**
	 * 修改，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		Role r = roleService.getById(model.getId());
		r.setName(model.getName());
		r.setDescription(model.getDescription());
		roleService.update(r);
		return "toList";
	}
	
	public String setPrivilegeUI() throws Exception{
		//取出所有的顶层权限数据
		List<Privilege> privilegeTopList = privilegeService.findTopList();
		ActionContext.getContext().put("privilegeTopList", privilegeTopList);
		
		//准备要回显的角色数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		//准备要回显的权限数据
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for(Privilege p : role.getPrivileges()){
			privilegeIds[index++] = p.getId();
		}
		return "setPrivilegeUI";
	}
	public String setPrivilege() throws Exception{
		//获得当前的角色对象
		Role role = roleService.getById(model.getId());
		//根据选中的id,获取相对应的权限列表
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		//为角色信息设置对应的权限信息
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		//更新对应的角色信息
		roleService.update(role);
		return "toList";
	}
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
}
