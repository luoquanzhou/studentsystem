package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
@Repository("ac")
public class AuthCodeUtil {
	private static String num;
	
	public static BufferedImage getAuthCode(int size, HttpServletRequest request){
		//获得画布
		BufferedImage image=new BufferedImage(100, 39, BufferedImage.TYPE_INT_BGR);
		//获得画笔
		Graphics g=image.getGraphics();
		//给比设置颜色
		g.setColor(new Color(255, 255, 255));
		//设置画布的beijingse 
		g.fillRect(0, 0, 100, 39);
		//重新给画笔设置颜色
		Random r=new Random();
		g.setFont(new Font(null, Font.BOLD+Font.ITALIC, 26));
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		//设置验证码的随机码
		String[] str=new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
				,"q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F"
				,"G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
				,"W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
		//生成一个四位字/size位符串
//		String num=str[r.nextInt(62)]+str[r.nextInt(62)]+str[r.nextInt(62)]+str[r.nextInt(62)];
		num="";
		for(int i=0;i<size;i++){
		num+=str[r.nextInt(62)];
		}
		
		//将字符串画在画布上
		g.drawString(num, 5, 30);
		//画10条随机的线
		for(int i=0;i<15;i++){
			g.drawLine(r.nextInt(100), r.nextInt(39), r.nextInt(100), r.nextInt(39));
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		}
		HttpSession session=request.getSession();
		session.setAttribute("code", num);
		
		return image;
	}
}
