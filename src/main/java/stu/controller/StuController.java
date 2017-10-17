package stu.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import info.StuCourinfo;
import info.Stuinfo;
import info.TeaCourinfo;
import info.Userinfo;
import stu.service.StuService;

@Controller("stuCon")
public class StuController {
	@Resource(name="stuService")
	private StuService stuservice;
	
	@ExceptionHandler
	public String exception(){
		return "error/error";
	}
	@RequestMapping("/student/stulist.do")
	public String stuList(HttpServletRequest request,HttpSession session){
		return "student/stuinformation";
	}
	
	@RequestMapping("/student/stuload.do")
	public String stuLoad(HttpServletRequest request,HttpSession session){
		return "student/stuinfo_modify";
	}
	@RequestMapping("/student/stumodify.do")
	public String stuModify(Stuinfo stu,HttpSession session){
		stuservice.updateStu(stu);
		stu=stuservice.findStuById(stu.getStuid());
		session.setAttribute("stu", stu);
		return "redirect:stulist.do";
	}
	@RequestMapping("/student/stulistcourse.do")
	public String stuListCourse(HttpServletRequest request,HttpSession session){
		Userinfo user=(Userinfo) session.getAttribute("userinfo");
		List<StuCourinfo> courses=stuservice.findStuCourById(user.getUsername());
		request.setAttribute("courses", courses);
		return "student/stucourse";
	}
	@RequestMapping("/student/stuallcourse.do")
	public String stuAllCourse(HttpServletRequest request,HttpSession session){
//		Userinfo user=(Userinfo) session.getAttribute("userinfo");
		List<TeaCourinfo> list=stuservice.findAllCour();
		request.setAttribute("courses", list);
		return "student/choose";
	}
	@RequestMapping("/student/stuchoosecourse.do")
	public void stuChooseCourse(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		String couid=request.getParameter("id");
//		StuCourinfo sc=new StuCourinfo();
		Userinfo user=(Userinfo) session.getAttribute("userinfo");
		Map<String, StuCourinfo> map=stuservice.findCoursByStuId(user.getUsername());
		try {
			if(!map.containsKey(couid)){
				stuservice.addStuCour(user.getUsername(),couid);
				response.sendRedirect("stulistcourse.do");
				//request.getRequestDispatcher("listcourse.do").forward(request, response);
			}else{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('你已选修了该门课程！');");
				out.print("window.location.href='stuallcourse.do'");
				out.print("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/student/studelcourse.do")
	public String stuDelCourse(HttpServletRequest request){
		String stucouid =request.getParameter("stucouid");
		String stuid =request.getParameter("stuid");
		stuservice.delStuCourById(stuid,stucouid);
		return "redirect:stulistcourse.do";
	}
}
