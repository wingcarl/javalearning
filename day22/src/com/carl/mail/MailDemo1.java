package com.carl.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailDemo1 {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();//环境变量设置。发送邮件时才需要
		props.setProperty("mail.transport.protocol", "smtp");//发送使用的协议
		props.setProperty("mail.host", "smtp.163.com");//发送服务器的主机地址
		props.setProperty("mail.smtp.auth", "true");//请求身份验证
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);//代表一封邮件
		message.setFrom(new InternetAddress("rdwhy11@163.com"));
		message.setRecipients(Message.RecipientType.TO, "rdwhy11@163.com");
		message.setSubject("this is the first mail");
		//设置文件的正文
		message.setText("java mail e-mail");
		
//		MimeBodyPart textPart = new MimeBodyPart();
//		textPart.setContent("aaa<br/><img src='cid:mm'/><br/>aaa","text/html");
//		
//		MimeBodyPart imagePart = new MimeBodyPart();
//		imagePart.setDataHandler(new DataHandler(new FileDataSource("F:/DSC_5021.JPG")));
//		imagePart.setContentID("mm");
//		
//		//描述二者的关系
//		MimeMultipart mmpart = new MimeMultipart();
//		mmpart.addBodyPart(textPart);
//		mmpart.addBodyPart(imagePart);
//		mmpart.setSubType("related");// 说明两部分是有关系的
//
//		MimeBodyPart textImagePart = new MimeBodyPart();
//		textImagePart.setContent(mmpart);
//		
//		MimeMultipart mpart2 = new MimeMultipart();
//		mpart2.addBodyPart(textImagePart);
//		
//		MimeBodyPart attachmentPart = new MimeBodyPart();
//		attachmentPart.setDataHandler(new DataHandler(new FileDataSource("F:/jeesite-master.zip")));
//		
//		mpart2.addBodyPart(attachmentPart);
//		mpart2.setSubType("mixed");
//		
//		message.setContent(mpart2);
//		message.saveChanges();
		//存在磁盘上
		//发送邮件
		Transport ts = session.getTransport();// 得到火箭
		ts.connect("rdwhy11", "*********");// 连接
		ts.sendMessage(message, message.getAllRecipients());

		ts.close();
		
	}
}


