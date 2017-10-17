package mail;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mailservice")
public class MailServiceImpl implements MailService,InitializingBean {
	@Resource(name="sendmail")
	private JavaMailSenderImpl sendmailimpl;
//	ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
//	private JavaMailSenderImpl sendmailimpl=ac.getBean("sendmail", JavaMailSenderImpl.class);
	public String sendAttachMail(String to) {
		System.out.println(sendmailimpl);
		//邮件服务器监听的端口
		sendmailimpl.setPort(465);
		//协议SMTP+SSL
		sendmailimpl.setProtocol("smtps");
		sendmailimpl.setDefaultEncoding("utf8");
		SimpleMailMessage smm=new SimpleMailMessage();
		//发送方邮箱
		smm.setFrom(sendmailimpl.getUsername());
		//接收方邮箱
		smm.setTo(to);
		//发送邮件的主题
		smm.setSubject("注册验证码");
		//发送邮件的内容
		//设置验证码的随机码
		Random r=new Random();
		String[] str=new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
						,"q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F"
						,"G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
						,"W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
		//生成一个四位字/size位符串
		String num="";
		for(int i=0;i<5;i++){
			num+=str[r.nextInt(62)];
		}
		smm.setText("欢迎您注册本网站，您本次的验证码为："+num+",请在30分钟内完成注册！");
		
		sendmailimpl.send(smm);
		return num;
	}
	/**
	 * 配置邮件发送器
	 */
	public void afterPropertiesSet() throws Exception {
		
		
	}

}
