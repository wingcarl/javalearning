package com.carl.base.generic;

public class GenericUtil {

	public static <T> void m1(T[] t, int index1, int index2){
		T temp = t[index1];
		t[index1] = t[index2];
		t[index2] = temp;
	}
}
