package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findChilderen(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findTopList() {
		
		return getSession().createQuery(//
				"FROM Department d where d.parent IS NULL")//
				.list();
	}

}
