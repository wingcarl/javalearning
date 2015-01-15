package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findTopList() {
		return getSession().createQuery("FROM Privilege WHERE parent IS NULL")//
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")//
				.list();	}

}
