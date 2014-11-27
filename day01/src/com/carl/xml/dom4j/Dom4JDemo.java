package com.carl.xml.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;









import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Assert;
import org.junit.Test;

public class Dom4JDemo {
//得到某个具体的节点内容：第2本书的作者
	@Test
	public void test1() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		List<Element> es = root.elements("书");
		Element author = es.get(1).element("作者");
		
		//System.out.println(author.getText());
		Assert.assertEquals("王昭珽", author.getText());
	}
	
	@Test
	public void test2() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		treeWalk(root);
	}
//	private void treeWalk(Element root){
//		System.out.println(root.getName());
//		List<Element> es = root.elements();
//		for(Element e : es){
//			treeWalk(e);
//		}
//	}
	private void treeWalk(Element root){
		System.out.println(root.getName());
		int count = root.nodeCount();
		for(int i=0; i<count; i++){
			Node node = root.node(i);
			if(node.getNodeType() == Node.ELEMENT_NODE)
				treeWalk((Element)node);
		}
	}
	
	@Test
	public void test3() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		Element secondBook = (Element)root.elements().get(1);
		 secondBook.element("售价").setText("29");
		 OutputStream out = new FileOutputStream("src/book.xml");
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 format.setEncoding("UTF-8");
		 XMLWriter writer = new XMLWriter(out,format);
		 writer.write(document);
		 writer.close();
	}
	
	@Test
	public void test4() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		firstBook.addElement("参考价").setText("9");
		
		 OutputStream out = new FileOutputStream("src/book.xml");
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 format.setEncoding("UTF-8");
		 XMLWriter writer = new XMLWriter(out,format);
		 writer.write(document);
		 writer.close();
	}
	
	@Test
	public void test5() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		Element price = DocumentHelper.createElement("内部价");
		price.setText("4");
		firstBook.elements().add(2, price);
		
		 OutputStream out = new FileOutputStream("src/book.xml");
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 format.setEncoding("UTF-8");
		 XMLWriter writer = new XMLWriter(out,format);
		 writer.write(document);
		 writer.close();
	}
	
	@Test
	public void test6() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		Element price = firstBook.element("批发价");
		firstBook.remove(price);
		
		 OutputStream out = new FileOutputStream("src/book.xml");
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 format.setEncoding("UTF-8");
		 XMLWriter writer = new XMLWriter(out,format);
		 writer.write(document);
		 writer.close();
	}
	
	@Test
	public void test7() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		firstBook.addAttribute("出版社", "船只博客");
		
		 OutputStream out = new FileOutputStream("src/book.xml");
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 format.setEncoding("UTF-8");
		 XMLWriter writer = new XMLWriter(out,format);
		 writer.write(document);
		 writer.close();
	}
	
	@Test
	public void test11() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		String xpath = "//书[2]/作者";
		Node author = document.selectSingleNode(xpath);
		
		//System.out.println(author.getText());
		Assert.assertEquals("王昭珽", author.getText());
	}
}
