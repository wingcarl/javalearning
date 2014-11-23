package com.carl.javalearning.IO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class CharsetL {

	public static void main(String[] args){
		encode();
	}
	/**
	 * 获得charset的别名的方法
	 */
	public static void charSetAlias(){
		Charset cset = Charset.forName("ISO-8859-1");
		Set<String> aliases =cset.aliases();
		for(String alias : aliases){
			System.out.println(alias);
		}
	}
	/**
	 * 获取本机可用的编码类型
	 */
	public static void charSetAvaliable(){
		Map<String,Charset> charsets = Charset.availableCharsets();
		for(String name : charsets.keySet())
			System.out.println(name);
	}
	
	/**
	 * UTF-8编码 中文占2-4个字节，UTF-8编码根据左侧的一的个数决定编码所占字节
	 * 例如 0~7 0XXX XXXX
		   8~11 110X XXXX 10XX XXXX
		   12~16 1110XXXX 10XX XXXX 10XX XXXX	
		   17~21 1111 0XXX 10XX XXXX 10XX XXXX 10XX XXXX 。。。
	 */
	public static void encode(){
		String str = "你";
		Charset cset = Charset.forName("UTF-8");
		ByteBuffer buffer = cset.encode(str);
		byte[] bytes = buffer.array();
		for(byte b : bytes) {
			System.out.println(b);
		}
		ByteBuffer bbuf = ByteBuffer.wrap(bytes,0,bytes.length);
		CharBuffer cbuf = cset.decode(bbuf);
		String str1 = cbuf.toString();
		System.out.println(str1);
 	}
}
