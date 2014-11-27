package com.carl.xml.sax;

import java.io.IOException;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAXDemo2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		XMLReader reader = parser.getXMLReader();
		reader.setContentHandler(new ContentHandler(){
			boolean isAuthor = false;
			int index = 0;
			@Override
			public void characters(char[] arg0, int arg1, int arg2)
					throws SAXException {
				if(isAuthor && index==1){
					System.out.println(new String(arg0,arg1,arg2));
				}
			}

			@Override
			public void endDocument() throws SAXException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void endElement(String arg0, String arg1, String arg2)
					throws SAXException {
				if("作者".equals(arg2)){
					index++;
				}
				isAuthor=false;
			}

			@Override
			public void endPrefixMapping(String arg0) throws SAXException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
					throws SAXException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void processingInstruction(String arg0, String arg1)
					throws SAXException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setDocumentLocator(Locator arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void skippedEntity(String arg0) throws SAXException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void startDocument() throws SAXException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void startElement(String arg0, String arg1, String arg2,
					Attributes arg3) throws SAXException {
				if(arg2.equals("作者")){
					isAuthor = true;
				}
				
			}

			@Override
			public void startPrefixMapping(String arg0, String arg1)
					throws SAXException {
				// TODO Auto-generated method stub
				
			}
			
		});
		reader.parse("src/book.xml");
		
	}
}
