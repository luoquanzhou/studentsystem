package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import info.Teainfo;
import tea.dao.TeainfoDAO;
import user.dao.UserDAO;
public class TestCast {
	private TeainfoDAO teadao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		teadao=ac.getBean("teainfoDAO", TeainfoDAO.class);
	}
	@Test
	//测试连接池
	public void tert1() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		DataSource ds=(DataSource) ac.getBean("ds");
		System.out.println(ds.getConnection());
	}
	
	@Test
	//测试连接池
	public void tert2() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		UserDAO user=ac.getBean("userDAO",UserDAO.class);
		System.out.println(user.findName("admin"));
	}
	@Test
	public void test3(){
		Teainfo tea=new Teainfo();
		tea.setTeaid("T123456");
		teadao.teasave(tea);
	}
	@Test
	public void test4(){
		System.out.println(teadao.findTeaAll());
	}
	@Test
	public void test5(){
		System.out.println(teadao.findTeaById("T123456"));
	}
	@Test
	public void test6(){
		System.out.println(teadao.findTeaByName("Mary"));
	}
	@Test
	public void test7(){
		Teainfo tea=new Teainfo("T123456", "Marys", "男", "20", "15872427669", "湖北宜昌", "Java", "1104874", "1104874@qq.com", "无");
	
		teadao.teaUpdate(tea);
	}
	@Test
	public void test8(){
		
		teadao.teadelete("T123456");
	}
	
	
}
