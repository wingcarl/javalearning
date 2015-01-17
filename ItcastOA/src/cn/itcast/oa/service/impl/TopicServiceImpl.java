package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.TopicService;

@Service
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findByForumId(Long id) {
		return getSession().createQuery("FROM Topic t WHERE t.forum.id=?")//
		.setParameter(0, id).list();
	}

}
