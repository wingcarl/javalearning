package com.carl.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JUtils {

	private static String dbFilePath = "";
	static {
		ClassLoader cl = Dom4JUtils.class.getClassLoader();
		URL url = cl.getResource("users.xml");
		dbFilePath = url.getPath();
	}
	
	public static Document getDocument() throws Exception{
		SAXReader reader  = new SAXReader();
		return reader.read(dbFilePath);
		
	}
	public static void write2Xml(Document document) throws Exception{
		XMLWriter writer = new XMLWriter(new FileOutputStream(dbFilePath),OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
}
