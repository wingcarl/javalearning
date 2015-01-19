package cn.itcast.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ReplyService;

@Service
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getByTopic(Topic topic) {
		return getSession()//
				.createQuery("FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)//
				.list();
	}

	@Override
	public void add(Reply reply) {
		reply.setPostTime(new Date());
		super.add(reply);
		
		Topic topic = reply.getTopic();
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		topic.setReplyCount(topic.getReplyCount()+1);
		getSession().save(topic);
		
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount()+1);
		getSession().save(forum);

	}
	
	

}
