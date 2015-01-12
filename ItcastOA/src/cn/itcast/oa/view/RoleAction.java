package cn.itcast.oa.view;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class RoleAction extends ActionSupport {

	/**
	 * 列表页面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		return "list";
	}
	/**
	 * 删除，完成之后转到列表页面
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		return "toList";
	}
	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		return "addUI";
	}
	/**
	 * 添加，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		return "toList";
	}
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		return "editUI";
	}
	/**
	 * 修改，完成之后重定向到列表页面
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		return "toList";
	}
}
