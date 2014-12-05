package com.carl.db;

import java.util.LinkedHashMap;
import java.util.Map;

import com.carl.model.Book;

public class BookDb {
	private static Map<String,Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("1", new Book("1","ISBN001","葵花宝典","东方不败",5f,"xiaoaojain"));
		books.put("2", new Book("2","ISBN002","辟邪剑谱","林平之",17f,"xiaoaojain"));
		books.put("3", new Book("3","ISBN003","神雕侠侣","于正",25f,"xiaoaojain"));
		books.put("4", new Book("4","ISBN004","九阴真金","郭襄",95f,"xiaoaojain"));
		books.put("5", new Book("5","ISBN005","玉女新经","林朝英",35f,"xiaoaojain"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String id){
		return books.get(id);
	}
}
