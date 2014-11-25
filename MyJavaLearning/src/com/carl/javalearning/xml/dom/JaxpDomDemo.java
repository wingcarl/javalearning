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
		//�õ���������DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//�õ�DocumentBuilder����
		DocumentBuilder builder = factory.newDocumentBuilder();
		//��xml���ص�dom����
		Document document = builder.parse("book.xml");
		test6(document);
	}
	//����ĳ������ڵ�����
	public static void test1(Document document){
		
		NodeList nl = document.getElementsByTagName("����");
		System.out.println(nl.item(1).getTextContent());
		
	}
	
	//��������Ԫ�ؽڵ�
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
	//�޸�һ��Ԫ��
	public static void test3(Document document) throws TransformerException{
		NodeList nl = document.getElementsByTagName("�ۼ�");
		nl.item(0).setTextContent("49");
		//���ڴ��е�Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("book.xml"));
	}
	
	//��ָ��Ԫ�ؽڵ�����һ���ӽڵ�
	public static void test4(Document document) throws TransformerException {
//		Element e = document.createElement("�ڲ���");
//		e.setTextContent("1");
		Element e1 = document.createElement("������");
		e1.setTextContent("4");
//		Node firstBookNode = document.getElementsByTagName("��").item(0);
//		firstBookNode.appendChild(e);
		
		Node refChild = document.getElementsByTagName("�ۼ�").item(0);
		refChild.getParentNode().insertBefore(e1, refChild);
		//���ڴ��е�Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("book.xml"));
	}
	
	//ɾ��ָ����Ԫ�ؽڵ㣬����Ҫ�ø��ڵ���ɾ��
	public static void test05(Document document) throws TransformerException{
		Node e = document.getElementsByTagName("�ڲ���").item(0);
		e.getParentNode().removeChild(e);
		//���ڴ��е�Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("book.xml"));
	}
	
	//����XML�ļ�����
	public static void test6(Document document) throws TransformerException{
		Node e = document.getElementsByTagName("��").item(0);
		System.out.println(e.getAttributes().item(0).getTextContent());
		Element el = (Element)e;
		el.setAttribute("CATAGORY", "IT");
		//���ڴ��е�Document��д��XML�ļ���
				TransformerFactory factory = TransformerFactory.newInstance();
				Transformer ts = factory.newTransformer();
				ts.transform(new DOMSource(document), new StreamResult("book.xml"));
		
	}
	
}
