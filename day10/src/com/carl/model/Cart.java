package com.carl.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {
	private Map<String,CartItem> items = new LinkedHashMap<String,CartItem>();
	private int num; //总数量
	private float price; //总计
	public Map<String, CartItem> getItems() {
		return items;
	}
	public int getNum() {
		num = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet()){
			num += me.getValue().getNum();
		}
		return num;
	}
	public float getPrice() {
		price = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet()){
			price += me.getValue().getPrice();
		}
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public void addBook2Cart(Book book){
		boolean buyed = false;
		//判断买的书之前有没有买过
		if(items.containsKey(book.getId())){
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			CartItem item = new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
		//买过，数量加一
		//没有买过：创建一个购物项，加入到items中
	}
	public void deleteBook(String bookId){
		if(items.containsKey(bookId)){
			items.remove(bookId);
		}		
	}
}
