package com.carl.db;

import java.util.LinkedHashMap;
import java.util.Map;

import com.carl.model.Book;

public class BookDb {
	private static Map<String,Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("1", new Book("1","ISBN001","��������","��������",5f,"xiaoaojain"));
		books.put("2", new Book("2","ISBN002","��а����","��ƽ֮",17f,"xiaoaojain"));
		books.put("3", new Book("3","ISBN003","�������","����",25f,"xiaoaojain"));
		books.put("4", new Book("4","ISBN004","�������","����",95f,"xiaoaojain"));
		books.put("5", new Book("5","ISBN005","��Ů�¾�","�ֳ�Ӣ",35f,"xiaoaojain"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String id){
		return books.get(id);
	}
}
