package cn.itcast.oa.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.opensymphony.xwork2.ActionContext;

@Entity
@Table(name="t_user")
public class User {

	
	private Long id;
	private String loginName;
	private String password;
	private String name;
	private String gender;
	private String phoneNumber;
	private String email;
	private String description;
	private Department department;
	private Set<Role> roles = new HashSet<Role>();
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="login_name")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public boolean hasPrivilegeByName(String name){
		if(isAdmin(1)){
			return true;
		}else{
			for(Role r:roles){
				for(Privilege p : r.getPrivileges()){
					if(p.getName().equals(name))
						return true;
				}
			}
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 如果是超级管理员，就有所有的权限
		if (isAdmin(1)) {
			return true;
		}

		// a, 去掉后面的参数字符串（如果有）
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		// b, 去掉后面的UI后缀（如果有）
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}

		// 如果是普通用户，就需要判断权限了
		// a, 如果这个URL是不需要控制的功能（登录后就能直接使用的），这是应直接返回true
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privUrl)) {
			return true;
		}
		// b, 如果这个URL是需要控制的功能（登录后还得有对应的权限才能使用的），这是应判断权限
		else {
			for (Role role : roles) {
				for (Privilege p : role.getPrivileges()) {
					if (privUrl.equals(p.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}
	
	/**
	 * 判断当前用户是否是超级管理员
	 */
	public boolean isAdmin(int i) {
		return "admin".equals(loginName);
	}
}
