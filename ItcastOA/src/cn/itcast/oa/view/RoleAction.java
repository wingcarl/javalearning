package cn.itcast.oa.view;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {

	@Resource
	private RoleService roleService;
	
	private Role model = new Role();
	
	/**
	 * 列表页面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		List<Role> roleList = roleService.list();
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
	
	@Override
	public Role getModel() {
		return model;
	}
	
	
}
