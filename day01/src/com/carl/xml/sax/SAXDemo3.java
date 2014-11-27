package com.carl.xml.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDemo3 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
	SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
	XMLReader reader = parser.getXMLReader();
	@SuppressWarnings("rawtypes")
	final List books = new ArrayList();
	reader.setContentHandler(new DefaultHandler(){
		Book book = null;
		String currentTagName = null;
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
			if("书名".equals(currentTagName)){
				book.setName(new String(ch,start,length));
			}
			if("作者".equals(currentTagName)){
				book.setAuthor(new String(ch,start,length));
			}
			if("售价".equals(currentTagName)){
				book.setPrice(Float.parseFloat(new String(ch,start,length)));
			}
			
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			if("书".equals(qName)){
				books.add(book);
				book = null;
			}
			currentTagName = null;
		}
	
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if("书".equals(qName)){
				book = new Book();
			}
			currentTagName = qName;
		}
		
	});
	reader.parse("src/book.xml");
	for(Object b:books){
		System.out.println(b.toString());
	}
}

class MyDefaultHandler implements ContentHandler{

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
}
