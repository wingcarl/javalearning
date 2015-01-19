package cn.itcast.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
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

	@Override
	public void add(Topic topic) {
		
		//业务层更新主题的一些信息
		topic.setPostTime(new Date()); //设置主题发表的时间
		topic.setType(Topic.TYPE_NORMAL); //主题的类型默认为普通类型
		topic.setLastReply(null); //主题的回复默认为null
		topic.setLastUpdateTime(topic.getPostTime()); //最后更新时间为主题发表时间
		topic.setReplyCount(0);
		getSession().save(topic);
		
		//同时需要更新一些forum的信息
		Forum forum = topic.getForum();
		forum.setLastTopic(topic);
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setArticleCount(forum.getArticleCount()+1);	
		getSession().update(forum);
	}

	@Override
	public void toElite(Long id) {
		Topic topic = getById(id);
		topic.setType(Topic.TYPE_BEST);
		super.update(topic);
	}

	@Override
	public void toNormal(Long id) {
		Topic topic = getById(id);
		topic.setType(Topic.TYPE_NORMAL);
		super.update(topic);
	}

	@Override
	public void toTop(Long id) {
		Topic topic = getById(id);
		topic.setType(Topic.TYPE_TOP);
		super.update(topic);
	}

	
}
