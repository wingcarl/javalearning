package com.carl.util;

import java.util.UUID;

public class IdGenerator {
	public static String genPrimaryKey(){
		return UUID.randomUUID().toString();
	}
}
