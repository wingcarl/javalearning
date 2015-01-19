package cn.itcast.oa.view;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> implements ModelDriven<Topic>{

	/**
	 * 
	 */
	private Long forumId;
	private Long topicId;
	private static final long serialVersionUID = 1L;
	
	public String show(){
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
		List<Reply> replyList = replyService.getByTopic(topic);
		ActionContext.getContext().put("replyList",replyList);
		return "show";
	}
	
	public String addUI() throws Exception{
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	public String add() throws Exception{
		Topic topic = new Topic();
		//从表单中获取的属性
		topic.setTitle(model.getTitle());
		topic.setContent(model.getContent());
		topic.setForum(forumService.getById(forumId));
		
		//在显示层才能获取的属性
		topic.setAuthor(getUser());
		topic.setIpAddr(getIpAddr());
		
		topicService.add(topic);
		ActionContext.getContext().put("topicId", topic.getId());
		return "toShow";
	}

	public String toTop() throws Exception{
		topicService.toTop(topicId);
		ActionContext.getContext().put("topicId", topicId);
		return "toShow";
	}
	public String toElite() throws Exception{
		topicService.toElite(topicId);
		ActionContext.getContext().put("topicId", topicId);
		return "toShow";
	}
	public String toNormal() throws Exception{
		topicService.toNormal(topicId);
		ActionContext.getContext().put("topicId", topicId);
		return "toShow";
	}
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
