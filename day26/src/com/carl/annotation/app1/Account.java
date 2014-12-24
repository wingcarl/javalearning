package com.carl.annotation.app1;

import java.lang.reflect.Method;

public class Account {
	private float amount;
	public Account(){
		
	}
	public Account (float amount){
		this.amount = amount;
	}
	@DrawMoney(limit=3000)
	public void getMoney(float money) throws NoSuchMethodException, SecurityException{
		if(money > amount)
			throw new RuntimeException("�Բ�������");
		
		Class clz = Account.class;
		Method m = clz.getMethod("getMoney",float.class);
		DrawMoney dm = m.getAnnotation(DrawMoney.class);
		int limit = Integer.MAX_VALUE;
		if(dm != null){
			limit = dm.limit();
		}
		if(money > limit)
			throw new RuntimeException("�Բ���ÿ��ȡ��ܳ���2000");
		System.out.println(money);
		amount -= money;
		System.out.println(amount);
	}
	

}
