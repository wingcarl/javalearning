package com.carl.cookie.app1;

import java.util.HashMap;
import java.util.Map;

public class BookDb {
	private static Map<String,Book> books = new HashMap<String,Book>();
	static{
		books.put("1", new Book("1","��������","��������",5,"xiaoaojain"));
		books.put("2", new Book("2","��а����","��ƽ֮",17,"xiaoaojain"));
		books.put("3", new Book("3","�������","����",25,"xiaoaojain"));
		books.put("4", new Book("4","�������","����",95,"xiaoaojain"));
		books.put("5", new Book("5","��Ů�¾�","�ֳ�Ӣ",35,"xiaoaojain"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String id){
		return books.get(id);
	}
}
