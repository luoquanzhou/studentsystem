package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import mail.MailService;
import mail.MailServiceImpl;

public class TestMail {
	@Resource(name="mailservice")
	MailServiceImpl ms;
	@Test
	public void test1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		JavaMailSenderImpl jmsi=ac.getBean("sendmail", JavaMailSenderImpl.class);
		System.out.println(jmsi.getHost());
		System.out.println(jmsi.getUsername());
		System.out.println(jmsi.getPassword());
		System.out.println(jmsi.getJavaMailProperties());
	}
	
	@Test
	public void test2(){
		ms.sendAttachMail("1104874504@qq.com");
		
	}
}
