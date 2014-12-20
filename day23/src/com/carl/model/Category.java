/**
 * 
 */
package com.carl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dell-pc
 *
 */

/* create database day23;
   use day23;
   create table category{
   	id varchar(100) primary key,
   	name varchar(100) not null unique,
   	description varchar(255)
   	};
 */

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private List<Book> books = new ArrayList<Book>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
