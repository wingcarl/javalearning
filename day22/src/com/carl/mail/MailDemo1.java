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
		Properties props = new Properties();//�����������á������ʼ�ʱ����Ҫ
		props.setProperty("mail.transport.protocol", "smtp");//����ʹ�õ�Э��
		props.setProperty("mail.host", "smtp.163.com");//���ͷ�������������ַ
		props.setProperty("mail.smtp.auth", "true");//���������֤
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);//����һ���ʼ�
		message.setFrom(new InternetAddress("rdwhy11@163.com"));
		message.setRecipients(Message.RecipientType.TO, "rdwhy11@163.com");
		message.setSubject("this is the first mail");
		//�����ļ�������
		message.setText("java mail e-mail");
		
//		MimeBodyPart textPart = new MimeBodyPart();
//		textPart.setContent("aaa<br/><img src='cid:mm'/><br/>aaa","text/html");
//		
//		MimeBodyPart imagePart = new MimeBodyPart();
//		imagePart.setDataHandler(new DataHandler(new FileDataSource("F:/DSC_5021.JPG")));
//		imagePart.setContentID("mm");
//		
//		//�������ߵĹ�ϵ
//		MimeMultipart mmpart = new MimeMultipart();
//		mmpart.addBodyPart(textPart);
//		mmpart.addBodyPart(imagePart);
//		mmpart.setSubType("related");// ˵�����������й�ϵ��
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
		//���ڴ�����
		//�����ʼ�
		Transport ts = session.getTransport();// �õ����
		ts.connect("rdwhy11", "*********");// ����
		ts.sendMessage(message, message.getAllRecipients());

		ts.close();
		
	}
}


