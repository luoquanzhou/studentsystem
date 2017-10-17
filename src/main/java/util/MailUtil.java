package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.stereotype.Repository;

public class MailUtil {
	/**
	 * 发送邮件的方法
	 * @param to			：给谁发送
	 * @param code		：发送的激活码
	 */
		public static void sendMail(String to,String code) throws Exception{
			//1.创建链接对象，链接到邮箱服务器
			Properties props=new Properties();
			Session session=Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("1104874504@qq.com", "xxx");
				}
			});
			//2.创建邮箱对象
			//2.1设置发送人
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress("1104874504@qq.com"));
			//2.2设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			//2.3设置邮件的主题
			message.setSubject("来自XXX的邮件");
			//2.4设置邮件的正文
			message.setContent("来自XXX的验证邮件,请在30分钟之后完成注册，验证码"+code, "text/html;charset=utf-8");
			//3.发送邮件
			Transport.send(message);
		}
}