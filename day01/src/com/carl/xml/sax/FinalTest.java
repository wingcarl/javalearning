package com.carl.xml.sax;

public class FinalTest {
	public static void test(int[] x){
		  x = new int[]{1,2,3};
		 }
	public static void main(String[] args){
		    int[] out = new int[]{4,5,6};
		    test(out);
		    System.out.println(out[0]);
		    System.out.println(out[1]);
		    System.out.println(out[2]);
	}
}
