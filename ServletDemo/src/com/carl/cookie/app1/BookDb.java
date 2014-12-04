package com.carl.cookie.app1;

import java.util.HashMap;
import java.util.Map;

public class BookDb {
	private static Map<String,Book> books = new HashMap<String,Book>();
	static{
		books.put("1", new Book("1","葵花宝典","东方不败",5,"xiaoaojain"));
		books.put("2", new Book("2","辟邪剑谱","林平之",17,"xiaoaojain"));
		books.put("3", new Book("3","神雕侠侣","于正",25,"xiaoaojain"));
		books.put("4", new Book("4","九阴真金","郭襄",95,"xiaoaojain"));
		books.put("5", new Book("5","玉女新经","林朝英",35,"xiaoaojain"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String id){
		return books.get(id);
	}
}
