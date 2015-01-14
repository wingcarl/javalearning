package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.domain.Department;

public interface DepartmentDao extends BaseDao<Department>{

	List<Department> findChilderen(Long parentId);

	List<Department> findTopList();
	
}
