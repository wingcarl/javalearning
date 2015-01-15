package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Privilege;


public interface PrivilegeService extends DaoSupport<Privilege> {

	public List<Privilege> findTopList();

	public List<String> getAllPrivilegeUrls();
}
