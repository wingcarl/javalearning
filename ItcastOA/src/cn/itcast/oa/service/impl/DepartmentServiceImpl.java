package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService{

//	@Resource
//	private DepartmentDao departmentDao;
//	@Override
//	public void delete(Long id) {
//		departmentDao.delete(id);
//	}
//
//	@Override
//	public List<Department> list() {
//		return departmentDao.findAll();
//	}
//
//	@Override
//	public void add(Department department) {
//		departmentDao.add(department);
//	}
//
//	@Override
//	public void update(Department department) {
//		departmentDao.update(department);
//	}
//
//	@Override
//	public Department getById(Long id) {
//		return departmentDao.getById(id);
//	}

	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

}
