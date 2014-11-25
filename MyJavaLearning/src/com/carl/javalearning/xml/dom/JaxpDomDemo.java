package com.carl.javalearning.xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxpDomDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		//得到解析工厂DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//得到DocumentBuilder对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//将xml加载到dom树中
		Document document = builder.parse("book.xml");
		test6(document);
	}
	//遍历某个具体节点内容
	public static void test1(Document document){
		
		NodeList nl = document.getElementsByTagName("作者");
		System.out.println(nl.item(1).getTextContent());
		
	}
	
	//遍历所有元素节点
	public static void test2(Node node){
		short type = node.getNodeType();
		if(type == Node.ELEMENT_NODE){
			System.out.println(node.getNodeName());
		}
		NodeList nl = node.getChildNodes();
		int len = nl.getLength();
		for (int i = 0; i < len; i++) {
			Node n = nl.item(i);
			test2(n);
		}
		}
	//修改一个元素
	public static void test3(Document document) throws TransformerException{
		NodeList nl = document.getElementsByTagName("售价");
		nl.item(0).setTextContent("49");
		//将内存中的Document树写回XML文件中
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("book.xml"));
	}
	
	//向指定元素节点增加一个子节点
	public static void test4(Document document) throws TransformerException {
//		Element e = document.createElement("内部价");
//		e.setTextContent("1");
		Element e1 = document.createElement("批发价");
		e1.setTextContent("4");
//		Node firstBookNode = document.getElementsByTagName("书").item(0);
//		firstBookNode.appendChild(e);
		
		Node refChild = document.getElementsByTagName("售价").item(0);
		refChild.getParentNode().insertBefore(e1, refChild);
		//将内存中的Document树写回XML文件中
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("book.xml"));
	}
	
	//删除指定的元素节点，必须要用父节点来删除
	public static void test05(Document document) throws TransformerException{
		Node e = document.getElementsByTagName("内部价").item(0);
		e.getParentNode().removeChild(e);
		//将内存中的Document树写回XML文件中
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("book.xml"));
	}
	
	//操作XML文件属性
	public static void test6(Document document) throws TransformerException{
		Node e = document.getElementsByTagName("书").item(0);
		System.out.println(e.getAttributes().item(0).getTextContent());
		Element el = (Element)e;
		el.setAttribute("CATAGORY", "IT");
		//将内存中的Document树写回XML文件中
				TransformerFactory factory = TransformerFactory.newInstance();
				Transformer ts = factory.newTransformer();
				ts.transform(new DOMSource(document), new StreamResult("book.xml"));
		
	}
	
}
