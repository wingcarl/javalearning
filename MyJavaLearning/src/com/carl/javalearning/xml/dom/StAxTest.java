package com.carl.javalearning.xml.dom;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAxTest {

	public static void main(String[] args) throws IOException, XMLStreamException {
		String urlString;
		if(args.length==0){
			urlString = "http://www.sina.com";
			System.out.println("Using "+ urlString);
		}
		else urlString = args[0];
		URL url = new URL(urlString);
		InputStream in = url.openStream();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader parser = factory.createXMLStreamReader(in);
		while(parser.hasNext()){
			int event = parser.next();
			if(event == XMLStreamConstants.START_ELEMENT){
				if(parser.getLocalName().equals("a")){
					String href = parser.getAttributeValue(null,"href");
					if(href != null)
						System.out.println(href);
				}
			}
		}
	}
}
