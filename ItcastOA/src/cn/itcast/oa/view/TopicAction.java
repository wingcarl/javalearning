package cn.itcast.oa.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> implements ModelDriven<Topic>{

	/**
	 * 
	 */
	private Long forumId;
	private static final long serialVersionUID = 1L;

	public String addUI() throws Exception{
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	public String add() throws Exception{
		topicService.add(model);
		return "toShow";
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
}
