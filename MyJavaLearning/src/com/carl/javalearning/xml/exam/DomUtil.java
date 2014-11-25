package com.carl.javalearning.xml.exam;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 操作xml的工具类
 * @author dell-pc
 *
 */
public class DomUtil {
	public static Document getDocument() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/exam.xml");
		return document;
	}
	public static void write2xml(Document document) throws TransformerFactoryConfigurationError, TransformerException{
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/exam.xml"));
	}
}
