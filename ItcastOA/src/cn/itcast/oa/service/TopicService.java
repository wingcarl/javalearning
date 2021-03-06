package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Topic;

public interface TopicService extends DaoSupport<Topic>{

	public List<Topic> findByForumId(Long id);
	
	public void toElite(Long id);
	
	public void toNormal(Long id);
	
	public void toTop(Long id);
}
