package com.carl.annotation.app1;

public class Client {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		Account a = new Account(4000);
		a.getMoney(3000);
	}
}
