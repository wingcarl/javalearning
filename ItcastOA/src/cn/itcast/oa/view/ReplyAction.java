package cn.itcast.oa.view;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> implements ModelDriven<Reply>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long topicId;
	
	
	public String addUI(){
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);;
		return "addUI";
	}
	
	public String add(){
		Reply reply = new Reply();
		reply.setContent(model.getContent());
		reply.setIpAddr(getIpAddr());
		reply.setTopic(topicService.getById(topicId));
		reply.setAuthor(getUser());
		
		replyService.add(reply);
		return "toTopicShow";
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
