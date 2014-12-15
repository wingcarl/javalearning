package model;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private IDCard idCard;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IDCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}
	
	
}
