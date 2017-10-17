package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import info.TeaCourinfo;
import tea.dao.TeaCourDAO;

public class TestTeaCou {
	private TeaCourDAO teacoudao;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		teacoudao=ac.getBean("teaCourDAO", TeaCourDAO.class);
	}
	
	@Test
	public void test1(){
		TeaCourinfo teacou=new TeaCourinfo();
		teacou.setCouid("C101");
		teacoudao.taeacousave(teacou);
	}
	@Test
	public void test2(){
		System.out.println(teacoudao.findTeaCourAll());
	}
	@Test
	public void test3(){
		System.out.println(teacoudao.findTeaCourByCouId("C100"));
	}
	@Test
	public void test4(){
		System.out.println(teacoudao.findTeaCourByCouName("Java"));
	}
	@Test
	public void test5(){
		System.out.println(teacoudao.findTeaCourByTeaId("T123456"));
	}
	@Test
	public void test6(){
		System.out.println(teacoudao.findTeaCourByTeaName("Mary"));
	}
	@Test
	public void test7(){
		TeaCourinfo teacou=new TeaCourinfo("C101", "Oracle", "2017-09-02", "8", "40", "T123456", "Mary");
		teacoudao.updateTeaCour(teacou);
	}
	@Test
	public void test8(){
		teacoudao.deleteTeaCourByCouID("C101");
		
	}
	@Test
	public void test9(){
		teacoudao.deleteTeaCourByTeaID("T123456");
		
	}
}
