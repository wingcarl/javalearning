package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {
	
//	@Resource
//	private RoleDao roleDao;
//	
//	/**
//	 * 删除岗位
//	 * @param id
//	 */
//	@Override
//	public void delete(Long id){
//		roleDao.delete(id);
//	}
//	/**
//	 * 查询所有的岗位记录
//	 * @return
//	 */
//	@Override
//	public List<Role> list(){
//		return roleDao.findAll();
//	}
//	
//	/**
//	 * 增加岗位信息
//	 */
//	@Override
//	public void add(Role role) {
//		roleDao.add(role);
//	}
//	
//	/**
//	 * 修改岗位信息
//	 */
//	@Override
//	public void update(Role role) {
//		roleDao.update(role);
//	}
//	@Override
//	public Role getById(Long id) {
//		return roleDao.getById(id);
//	}
}
