package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 权限实体
 * @author dell-pc
 *
 */
@Entity
@Table(name="t_privilege")
public class Privilege {

	/**
	 * 权限id
	 */
	private Long id;
	/**
	 * 权限对应的名称
	 */
	private String name;
	/**
	 * 权限对应的url
	 */
	private String url;
	/**
	 * 拥有该权限的角色
	 */
	private Set<Role> roles = new HashSet<Role>();
	/**
	 * 该权限的父权限
	 */
	private Privilege parent;
	/**
	 * 该权限的子权限
	 */
	private Set<Privilege> children = new HashSet<Privilege>();
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToMany
	@JoinTable(name = "t_privilege_role", joinColumns = { @JoinColumn(name = "privilege_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	
	@OneToMany(mappedBy="parent")
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	
	public Privilege(){
		
	}
	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	

}
