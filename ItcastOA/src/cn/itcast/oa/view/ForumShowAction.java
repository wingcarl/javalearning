package cn.itcast.oa.view;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class ForumShowAction extends BaseAction<Forum> implements ModelDriven<Forum>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String list(){
		List<Forum>  forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	
	public String show(){
		// 准备数据: topicList
		List<Topic> topicList = topicService.findByForumId(model.getId());
		ActionContext.getContext().put("topicList", topicList);
		
		// 准备数据：Forum
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		
		return "show";
	}

}
