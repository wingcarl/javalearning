package com.carl.javalearning.xml.exam;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentDao {

	public boolean addStudent(Student s) {
		try {
			Document document = DomUtil.getDocument();
			Element nameE = document.createElement("name");
			nameE.setTextContent(s.getName());
			Element locationE = document.createElement("location");
			locationE.setTextContent(s.getLocation());
			Element gradeE = document.createElement("grade");
			gradeE.setTextContent(s.getGrade()+"");
			Element studentE = document.createElement("student");
			studentE.setAttribute("idcard", s.getIdcard());
			studentE.setAttribute("examid", s.getExamid());
			
			studentE.appendChild(nameE);
			studentE.appendChild(locationE);
			studentE.appendChild(gradeE);
			
			Node node = document.getElementsByTagName("exam").item(0);
			node.appendChild(studentE);
			try {
				DomUtil.write2xml(document);
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			throw new RuntimeException();
		} catch (SAXException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return true;
	}
	
	public boolean deleteStudent(String examid){
		Document document;
		try {
			document = DomUtil.getDocument();
			NodeList nl = document.getElementsByTagName("student");
			for(int i=0; i<nl.getLength();i++){
				Node node = nl.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE){
					Element e = (Element)node;
					if(e.getAttribute("examid").equals(examid)){
						e.getParentNode().removeChild(e);
						break;
					}

			}
			}
			try {
				DomUtil.write2xml(document);
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Student findStudent(String examid){
		try {
			Document document = DomUtil.getDocument();
			NodeList nl = document.getElementsByTagName("student");
			for(int i=0; i<nl.getLength();i++){
				Node node = nl.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE){
					Element e = (Element)node;
					if(e.getAttribute("examid").equals(examid)){
						Student s = new Student();
						s.setExamid(examid);
						s.setIdcard(e.getAttribute("idcard"));
						s.setName(e.getElementsByTagName("name").item(0).getTextContent());
						s.setLocation(e.getElementsByTagName("location").item(0).getTextContent());
						s.setGrade(Float.parseFloat(e.getElementsByTagName("grade").item(0).getTextContent()));
						return s;
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
}
