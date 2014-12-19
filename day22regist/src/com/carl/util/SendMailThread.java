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
		//发送邮件
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");//发送使用的协议
			props.setProperty("mail.host", "smtp.163.com");//发送服务器的主机地址
			props.setProperty("mail.smtp.auth", "true");//请求身份验证
			Session session = Session.getDefaultInstance(props);
			session.setDebug(true);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rdwhy11@163.com"));
			message.setRecipients(Message.RecipientType.TO, user.getEmail());
			message.setSubject("感谢你注册网站的会员");
			
			MimeBodyPart part = new MimeBodyPart();
			part.setContent("这是一封来自激活邮件！<br/>" +
					"请点击以下链接<a href='http://localhost:8080/day22regist/ActiviteServlet?code="+user.getCode()+"'>http://localhost:8080/day22regist/ActiviteServlet?code="+user.getCode()+"</a>激活您的账户<br/>" +
							"或者拷贝以上链接到您的地址栏中。<br/>！！！<br/>" +
							"本邮件由系统自动发出，请不要直接回复", "text/html;charset=UTF-8");
			
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
