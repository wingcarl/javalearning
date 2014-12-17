package com.carl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.Menu;
import com.carl.model.Role;
import com.carl.model.User;
import com.carl.service.BusinessService;
import com.carl.service.impl.BusinessServiceImpl;
import com.carl.util.WebUtil;

/**
 * Servlet implementation class MyController
 */
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BusinessService bs = new BusinessServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("listAllMenus"))
			listAllMenus(request,response);
		if(operation.equals("addMenu"))
			addMenu(request,response);
		if(operation.equals("listAllRole"))
			addAllRole(request,response);
		if(operation.equals("addRole"))
			addRole(request,response);
		if(operation.equals("grantMenu2RoleUI"))
			grantMenu2RoleUI(request,response);
		if(operation.equals("grantMenu2Role"))
			grantMenu2Role(request,response);
		if(operation.equals("listAllUser"))
			listAllUsers(request,response);
		if(operation.equals("addUser"))
			addUser(request,response);
		if(operation.equals("grantRole2UserUI"))
			grantRole2UserUI(request,response);
		if(operation.equals("grantRole2User"))
			grantRole2User(request,response);
		if(operation.equals("showClientMenu"))
			showClientMenu(request,response);
	}

	//展示前台的所有菜单
	private void showClientMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Menu> menus = bs.findAllMenu();
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
		
		
		
	}

	private void grantRole2User(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String[] mIds = request.getParameterValues("mIds");
		if(mIds!=null && mIds.length>0){
			bs.grantRole2User(userId,mIds);
		}
		request.getRequestDispatcher("MyController?operation=listAllUser").forward(request, response);
		
	}

	private void grantRole2UserUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = bs.findUserById(userId);//还要查询出该角色已经有的菜单
		List<Role> roles = bs.findAllRole();
		request.setAttribute("roles", roles);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/manager/grantRole.jsp").forward(request, response);
		
	}

	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resultPath = "";
		User u = WebUtil.fillBean(request, User.class);	
		bs.addUser(u);
		resultPath = "/manager/addUser.jsp";
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

	private void listAllUsers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<User> users = bs.listAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/manager/listUsers.jsp").forward(request, response);
	}

	private void grantMenu2Role(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		String[] mIds = request.getParameterValues("mIds");
		if(mIds!=null && mIds.length>0){
			bs.grantMenu2Role(roleId,mIds);
		}
		request.getRequestDispatcher("MyController?operation=listAllRole").forward(request, response);
	}

	private void grantMenu2RoleUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		Role role = bs.findRoleById(roleId);//还要查询出该角色已经有的菜单
		List<Menu> menus = bs.findAllMenu();
		request.setAttribute("menus", menus);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/manager/grantMenu.jsp").forward(request, response);
		
		
	}

	private void addRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resultPath = "";
		Role m = WebUtil.fillBean(request, Role.class);
		bs.addRole(m);
		resultPath = "/manager/addRole.jsp";
		request.getRequestDispatcher(resultPath).forward(request, response);
		
	}

	private void addAllRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Role> roles = bs.findAllRole();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manager/listRoles.jsp").forward(request, response);
		
	}

	private void addMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resultPath = "";
		Menu m = WebUtil.fillBean(request, Menu.class);
		bs.addMenu(m);
		resultPath = "/manager/addMenu.jsp";
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

	private void listAllMenus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Menu> menus = bs.findAllMenu();
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("/manager/listMenus.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
