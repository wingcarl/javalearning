package com.carl.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.carl.model.User;

public class SendMailThread extends Thread {
	private User user;
	public SendMailThread(User user){
		this.user = user;
	}
	@Override
	public void run() {
		//�����ʼ�
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");//����ʹ�õ�Э��
			props.setProperty("mail.host", "smtp.163.com");//���ͷ�������������ַ
			props.setProperty("mail.smtp.auth", "true");//���������֤
			Session session = Session.getDefaultInstance(props);
			session.setDebug(true);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rdwhy11@163.com"));
			message.setRecipients(Message.RecipientType.TO, user.getEmail());
			message.setSubject("��л��ע����վ�Ļ�Ա");
			
			MimeBodyPart part = new MimeBodyPart();
			part.setContent("����һ�����Լ����ʼ���<br/>" +
					"������������<a href='http://localhost:8080/day22regist/ActiviteServlet?code="+user.getCode()+"'>http://localhost:8080/day22regist/ActiviteServlet?code="+user.getCode()+"</a>���������˻�<br/>" +
							"���߿����������ӵ����ĵ�ַ���С�<br/>������<br/>" +
							"���ʼ���ϵͳ�Զ��������벻Ҫֱ�ӻظ�", "text/html;charset=UTF-8");
			
			MimeMultipart mpart = new MimeMultipart();
			mpart.addBodyPart(part);
			message.setContent(mpart);
			message.saveChanges();
			
			Transport ts = session.getTransport();
			ts.connect("rdwhy11", "******");
			ts.sendMessage(message,message.getAllRecipients());
			ts.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
}
