package cn.itcast.oa.view;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> implements ModelDriven<Forum>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String list() throws Exception{
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	/**
	 * 删除，完成之后转到列表页面
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		forumService.delete(model.getId());
		return "toList";
	}
	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		return "saveUI";
	}
	/**
	 * 添加，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		forumService.add(model);
		return "toList";
	}
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		Forum forum = new Forum();
		forum = forumService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);
		return "saveUI";
	}
	/**
	 * 修改，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		Forum forum = forumService.getById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumService.update(forum);
		return "toList";
	}
	
	public String moveUp() throws Exception{
		forumService.moveUp(model.getId());
		return "toList";
	}
	
	public String moveDown() throws Exception{
		forumService.moveDown(model.getId());
		return "toList";
	}
}
