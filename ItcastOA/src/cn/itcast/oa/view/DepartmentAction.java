package cn.itcast.oa.view;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.util.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
	private Long parentId;
	
	public String list() throws Exception{
		List<Department> des = null;
		if(parentId == null){
			des = departmentService.findTopList();
		}else{
			des = departmentService.findChildren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent",parent);
		}
		ActionContext.getContext().put("des", des);
		return "list";
	}
	
	public String delete() throws Exception{
		departmentService.delete(model.getId());
		return "toList";
	}
	
	public String addUI() throws Exception{
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, null);	
		ActionContext.getContext().put("departmentList", departmentList);
		return "addUI";
	}
	public String add() throws Exception{
		Department department = new Department();
		department.setId(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);
		departmentService.add(department);
		return "toList";
	}
	public String editUI() throws Exception{
		Department department = new Department();
		department = departmentService.getById(model.getId());
		if (department.getParent() != null) {
			this.parentId = department.getParent().getId();
		}
		ActionContext.getContext().getValueStack().push(department);
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, department);			
		ActionContext.getContext().put("departmentList", departmentList);

		return "editUI";
	}
	public String edit() throws Exception{
		Department department = new Department();
		department.setId(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);
		departmentService.update(department);
		return "toList";
	}
	

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
}
