package com.carl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MailClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("smtp.sina.com", 25);
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	}

}
