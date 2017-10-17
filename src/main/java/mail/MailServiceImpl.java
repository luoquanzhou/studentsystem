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
		//�ʼ������������Ķ˿�
		sendmailimpl.setPort(465);
		//Э��SMTP+SSL
		sendmailimpl.setProtocol("smtps");
		sendmailimpl.setDefaultEncoding("utf8");
		SimpleMailMessage smm=new SimpleMailMessage();
		//���ͷ�����
		smm.setFrom(sendmailimpl.getUsername());
		//���շ�����
		smm.setTo(to);
		//�����ʼ�������
		smm.setSubject("ע����֤��");
		//�����ʼ�������
		//������֤��������
		Random r=new Random();
		String[] str=new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
						,"q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F"
						,"G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
						,"W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
		//����һ����λ��/sizeλ����
		String num="";
		for(int i=0;i<5;i++){
			num+=str[r.nextInt(62)];
		}
		smm.setText("��ӭ��ע�᱾��վ�������ε���֤��Ϊ��"+num+",����30���������ע�ᣡ");
		
		sendmailimpl.send(smm);
		return num;
	}
	/**
	 * �����ʼ�������
	 */
	public void afterPropertiesSet() throws Exception {
		
		
	}

}
