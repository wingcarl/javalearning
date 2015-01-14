package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Department;


public interface DepartmentService extends DaoSupport<Department>{

	
	/**
	 * 根据ID获取单独的部门信息
	 * @param id
	 * @return
	 */
	public Department getById(Long id);
	/**
	 * 获得顶级部门信息
	 * @return
	 */
	public List<Department> findTopList();
	/**
	 * 根据上级部门获取子部门的信息
	 * @param parentId
	 * @return
	 */
	public List<Department> findChildren(Long parentId);
}
